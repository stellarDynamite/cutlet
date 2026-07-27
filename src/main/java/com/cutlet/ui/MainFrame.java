package com.cutlet.ui;

import com.cutlet.ffmpeg.FFmpegUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.URL;

public class MainFrame extends JFrame {

    public MainFrame() {

        setTitle("Cutlet");
        setSize(1200, 760);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(Theme.BACKGROUND);

        // ================= HEADER =================

        GradientPanel header = new GradientPanel(
                new Color(213,205,255),
                new Color(251,228,239));

        header.setPreferredSize(new Dimension(0,90));
        header.setLayout(new BorderLayout());
        header.setBorder(new EmptyBorder(18,30,18,30));

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        titlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title = new JLabel("Cutlet");
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setForeground(Theme.TEXT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle =
                new JLabel("Letting Java do the cutting.");

        subtitle.setFont(
                new Font("SansSerif",
                        Font.ITALIC,
                        14));

        subtitle.setForeground(
                new Color(126,112,165));

        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        titlePanel.add(title);
        titlePanel.add(subtitle);

        header.add(titlePanel, BorderLayout.CENTER);

        // ================= SIDEBAR =================

        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(220,0));
        sidebar.setBackground(new Color(230,226,255));
        sidebar.setLayout(new BorderLayout());

        URL url =
                getClass().getResource("/images/banner.jpg");

        ImageIcon icon =
                new ImageIcon(url);

        Image scaled =
                icon.getImage().getScaledInstance(
                        170,
                        300,
                        Image.SCALE_SMOOTH);

        JLabel artwork =
                new JLabel(new ImageIcon(scaled));

        artwork.setHorizontalAlignment(
                SwingConstants.CENTER);

        JPanel holder =
                new JPanel(new GridBagLayout());

        holder.setOpaque(false);

        holder.add(artwork);

        sidebar.add(holder, BorderLayout.CENTER);

        // ================= CONTENT =================

        JPanel content = new JPanel();
        content.setBackground(Theme.BACKGROUND);
        content.setBorder(new EmptyBorder(25,25,25,25));
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
// ================= INPUT CARD =================

RoundedPanel inputCard = new RoundedPanel();

inputCard.setPreferredSize(new Dimension(700,120));
inputCard.setMaximumSize(new Dimension(Integer.MAX_VALUE,120));

inputCard.setLayout(new BorderLayout());
inputCard.setBorder(new EmptyBorder(20,20,20,20));

JLabel inputLabel = new JLabel("Input File");
inputLabel.setFont(Theme.LABEL);

JPanel row = new JPanel(new BorderLayout(10,0));
row.setOpaque(false);

JTextField input = new JTextField();

JButton browse = new JButton("Browse");

browse.addActionListener(e -> {

    JFileChooser chooser = new JFileChooser();

    if (chooser.showOpenDialog(this)
            == JFileChooser.APPROVE_OPTION){

        input.setText(
                chooser.getSelectedFile()
                        .getAbsolutePath());

    }

});

row.add(input,BorderLayout.CENTER);
row.add(browse,BorderLayout.EAST);

inputCard.add(inputLabel,BorderLayout.NORTH);
inputCard.add(row,BorderLayout.CENTER);

content.add(inputCard);

content.add(Box.createVerticalStrut(20));


// ================= OUTPUT CARD =================

RoundedPanel outputCard = new RoundedPanel();

outputCard.setPreferredSize(new Dimension(700,120));
outputCard.setMaximumSize(new Dimension(Integer.MAX_VALUE,120));

outputCard.setLayout(new BorderLayout());
outputCard.setBorder(new EmptyBorder(20,20,20,20));

JLabel outputLabel =
        new JLabel("Output File Name");

outputLabel.setFont(Theme.LABEL);

JPanel row2 =
        new JPanel(new BorderLayout(10,0));

row2.setOpaque(false);

JTextField output =
        new JTextField("output");

row2.add(output,BorderLayout.CENTER);

outputCard.add(outputLabel,BorderLayout.NORTH);
outputCard.add(row2,BorderLayout.CENTER);

content.add(outputCard);

content.add(Box.createVerticalStrut(20));


// ================= OPERATION CARD =================

RoundedPanel operation =
        new RoundedPanel();

operation.setMaximumSize(
        new Dimension(Integer.MAX_VALUE,220));

operation.setLayout(
        new BoxLayout(
                operation,
                BoxLayout.Y_AXIS));

operation.setBorder(
        new EmptyBorder(
                20,20,20,20));

JLabel opLabel =
        new JLabel("Operation");

opLabel.setFont(Theme.LABEL);

String[] options = {

        "Convert",
        "Extract Audio"

};

JComboBox<String> combo =
        new JComboBox<>(options);

combo.setMaximumSize(
        new Dimension(
                Integer.MAX_VALUE,
                38));

operation.add(opLabel);

operation.add(
        Box.createVerticalStrut(10));

operation.add(combo);

operation.add(
        Box.createVerticalStrut(15));

JLabel helper =
        new JLabel(
                "<html>" +
                        "<b>Supported</b><br>" +
                        "• Video → Video<br>" +
                        "• Audio → Audio<br>" +
                        "• Video → Audio" +
                        "</html>");

helper.setForeground(
        Theme.SUBTEXT);

operation.add(helper);

operation.add(
        Box.createVerticalStrut(20));

JButton execute =
        new JButton("Convert");

execute.setAlignmentX(
        Component.CENTER_ALIGNMENT);

combo.addActionListener(e->{

    if(combo.getSelectedIndex()==0){

        execute.setText("Convert");

    }else{

        execute.setText("Extract Audio");

    }

});

operation.add(execute);
execute.addActionListener(e -> {

    if (input.getText().isBlank()) {

        JOptionPane.showMessageDialog(
                this,
                "Please choose an input file.",
                "Missing Input",
                JOptionPane.WARNING_MESSAGE);

        return;
    }

    if (output.getText().isBlank()) {

        JOptionPane.showMessageDialog(
                this,
                "Please enter an output filename.",
                "Missing Output",
                JOptionPane.WARNING_MESSAGE);

        return;
    }

    try {

        String out = output.getText().trim();

        if(combo.getSelectedIndex() == 0){

    if(!out.contains(".")){

        out += ".mp4";

    }

}

        if (combo.getSelectedIndex() == 0) {

            FFmpegUtil.convert(
                    input.getText(),
                    out
            );

        } else {

            if (!out.toLowerCase().endsWith(".mp3")) {
                out += ".mp3";
            }

            FFmpegUtil.extractAudio(
                    input.getText(),
                    out
            );

        }

        JOptionPane.showMessageDialog(
                this,
                "Done!\n\nSaved as:\n" + out,
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(
                this,
                ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );

    }

});

content.add(operation);

        root.add(header,BorderLayout.NORTH);
        root.add(sidebar,BorderLayout.WEST);
        root.add(content,BorderLayout.CENTER);

        setContentPane(root);

    }

    
}