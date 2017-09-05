package com.view;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class ImgBack extends JPanel{
	Image im=null;
	public ImgBack(Image im)
	{
		this.im=im;
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(w,h);
		this.setVisible(true);
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(im, 0, 0, this.getWidth(),this.getHeight(),this);
	}
	

}
