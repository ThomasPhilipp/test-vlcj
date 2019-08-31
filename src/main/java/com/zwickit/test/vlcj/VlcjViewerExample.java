package com.zwickit.test.vlcj;

import uk.co.caprica.vlcj.discovery.NativeDiscovery;

import javax.swing.*;

public class VlcjViewerExample {

    public static void main(String[] args) {
        new NativeDiscovery().discover();

        SwingUtilities.invokeLater(() -> new UdpViewer().play());
    }

}
