package com.zwickit.test.vlcj;

import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;

import javax.swing.*;
import java.awt.*;

public class UdpViewer {

    private final MediaPlayerFactory mediaPlayerFactory;
    private final EmbeddedMediaPlayer mediaPlayer;

    public UdpViewer() {
        JFrame frame = new JFrame("UDP Viewer");

        final String[] libvlcArgs = new String[] {"--vout=xcb_xv", "-vv"};
        mediaPlayerFactory = new MediaPlayerFactory(libvlcArgs);

        Canvas canvas = new Canvas();
        CanvasVideoSurface videoSurface = mediaPlayerFactory.newVideoSurface(canvas);

        mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
        mediaPlayer.setVideoSurface(videoSurface);

        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(canvas, BorderLayout.CENTER);

        frame.setContentPane(panel);
        frame.setSize(1366, 1024);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void play() {
        mediaPlayer.playMedia("udp://@192.168.1.99:5000");
    }
}
