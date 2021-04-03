package fr.ntdt.game.shooter.objet;

import java.util.Objects;
import java.util.UUID;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

/**
 * Objet animé
 */
public abstract class Objet /* extends Panel */ {

    private UUID id;

    // Nom de l'objet
    private String nom;

    // Position de l'objet dans la scene
    protected Point pos;

    // Image de l'objet
    protected Image image;

    /**
     * 
     * @param nom      Nom de l'objet
     * @param imageUri Chemin de l'image (ex: src/resources/monimage.png)
     */
    protected Objet(String nom, String imageUri) {
        id = UUID.randomUUID();
        this.nom = nom;
        pos = new Point(0, 0);

        // Charger l'image
        ImageIcon imgIcon = new ImageIcon(imageUri);
        setImage(imgIcon.getImage());

        System.out.println("Créer objet : " + nom + " (L=" + getLargeur() + " H=" + getHauteur() + ")");
    }

    public UUID getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public Point getPos() {
        return this.pos;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public Objet pos(Point pos) {
        setPos(pos);
        return this;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
        if (image != null && image.getWidth(null) > 0) {
            // Rendre trasparent la couleur noir
            // BufferedImage bufferImg = imageToBufferedImage(image);
            // int color = bufferImg.getRGB(0, 0);
            // Image imageWithTransparency = makeColorTransparent(bufferImg, new Color(0, 0
            //
            // 0));
            // image = imageWithTransparency;
        }
    }

    public Objet image(Image image) {
        setImage(image);
        return this;
    }

    public int getLargeur() {
        return image == null ? 0 : image.getWidth(null);
    }

    public int getHauteur() {
        return image == null ? 0 : image.getHeight(null);
    }

    /**
     * Deplacer l'objet vers une nouvelle position
     * 
     * @param dx
     * @param dy
     */
    public void deplacer(int dx, int dy) {
        pos.setX(dx);
        pos.setY(dy);
    }

    /**
     * Dessiner l'objet
     * 
     * @param g
     * @param observer
     */
    public void dessiner(Graphics g, ImageObserver observer) {

        // Afficher l'objet
        if (image != null)
            g.drawImage(image, pos.getX() - 25, pos.getY(), observer);
        else {
            g.setColor(Color.WHITE);
            g.fillOval(pos.getX(), pos.getY(), 5, 5);
            // Afficher le nom de l'objet
            g.setColor(Color.WHITE);
            g.setFont(new Font("Monospaced", Font.PLAIN, 10));
            g.drawString(nom, pos.getX(), pos.getY() + 10);
        }
    }

    /**
     * Effectuer une rotation de l'ojet en fonction de l'angle spécifié
     * 
     * @param angle
     */
    public void rotation(int angle) {
        setImage(rotateImage(imageToBufferedImage(image), angle));
    }

    /**
     * Cette méthode est appelée si l'ojet est touchée par un autre objet
     * 
     * @param objet
     */
    public abstract void touche(Objet objet);

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Objet)) {
            return false;
        }
        Objet objet = (Objet) o;
        return Objects.equals(id, objet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return getNom() + " {" + " id='" + getId() + "'" + ", pos='" + getPos() + "'" + "}";
    }

    /**
     * 
     * @param src
     * @param angle
     * @return
     */
    public static BufferedImage rotateImage(BufferedImage image, int angle) {
        double theta = (Math.PI * 2) / 360 * angle;
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage dest;
        if (angle == 90 || angle == 270) {
            dest = new BufferedImage(image.getHeight(), image.getWidth(), image.getType());
        } else {
            dest = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        }

        Graphics2D graphics2D = dest.createGraphics();

        if (angle == 90) {
            graphics2D.translate((height - width) / 2, (height - width) / 2);
            graphics2D.rotate(theta, height / 2, width / 2);
        } else if (angle == 270) {
            graphics2D.translate((width - height) / 2, (width - height) / 2);
            graphics2D.rotate(theta, height / 2, width / 2);
        } else {
            graphics2D.translate(0, 0);
            graphics2D.rotate(theta, width / 2, height / 2);
        }
        graphics2D.drawRenderedImage(image, null);
        return dest;
    }

    /**
    * 
    */
    private static BufferedImage imageToBufferedImage(final Image image) {
        final BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        final Graphics2D g2 = bufferedImage.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return bufferedImage;
    }

    /**
     * Make provided image transparent wherever color matches the provided color.
     *
     * @param im    BufferedImage whose color will be made transparent.
     * @param color Color in provided image which will be made transparent.
     * @return Image with transparency applied.
     */
    public static Image makeColorTransparent(final BufferedImage im, final Color color) {
        final ImageFilter filter = new RGBImageFilter() {
            // the color we are looking for (white)... Alpha bits are set to opaque
            public int markerRGB = color.getRGB() | 0xFFFFFFFF;

            public final int filterRGB(final int x, final int y, final int rgb) {
                if ((rgb | 0xFF000000) == markerRGB) {
                    // Mark the alpha bits as zero - transparent
                    return 0x00FFFFFF & rgb;
                } else {
                    // nothing to do
                    return rgb;
                }
            }
        };

        final ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }
}
