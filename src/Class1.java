import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

public class Class1 {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		String path = "C:\\Users\\Administrator\\Desktop\\gi\\opencv-master\\samples\\data\\messi5.jpg";

		Mat img = Imgcodecs.imread(path);

		MatOfByte mat = new MatOfByte();
		Imgcodecs.imencode(".jpg", img, mat);
		byte[] byteArray = mat.toArray();
		InputStream in = new ByteArrayInputStream(byteArray);
		BufferedImage buf = null;
		try {
			buf = ImageIO.read(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JFrame fr = new JFrame();
		fr.getContentPane().add(new JLabel(new ImageIcon(buf)));
		fr.pack();
		fr.setVisible(true);

	}
}
