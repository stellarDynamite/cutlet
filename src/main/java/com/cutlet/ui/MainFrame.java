package com.cutlet.ui;
import com.cutlet.ffmpeg.FFmpegUtil;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        setTitle("Cutlet ✂");
        setSize(1200, 760);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(Theme.BACKGROUND);

        // ================= HEADER =================

        GradientPanel header = new GradientPanel(
                new Color(213, 205, 255),
                new Color(251, 228, 239));

        header.setPreferredSize(new Dimension(0, 90));
        header.setLayout(new BorderLayout());
        header.setBorder(new EmptyBorder(18, 30, 18, 30));

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("✂ Cutlet");
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setForeground(Theme.TEXT);

        JLabel subtitle = new JLabel("Cute FFmpeg Media Studio");
        subtitle.setForeground(Theme.SUBTEXT);

        titlePanel.add(title);
        titlePanel.add(subtitle);

        header.add(titlePanel, BorderLayout.WEST);

        // ================= SIDEBAR =================

        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(220, 0));
        sidebar.setBackground(new Color(230, 226, 255));
        sidebar.setLayout(new BorderLayout());

        JLabel cat = new JLabel("🐈", SwingConstants.CENTER);
        cat.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 80));

        sidebar.add(cat, BorderLayout.CENTER);

        // ================= CONTENT =================

        JPanel content = new JPanel();
        content.setBackground(Theme.BACKGROUND);
        content.setBorder(new EmptyBorder(25,25,25,25));
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

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

    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
        input.setText(
                chooser.getSelectedFile().getAbsolutePath()
        );
    }

});

        row.add(input,BorderLayout.CENTER);
        row.add(browse,BorderLayout.EAST);

        inputCard.add(inputLabel,BorderLayout.NORTH);
        inputCard.add(row,BorderLayout.CENTER);

        content.add(inputCard);

        content.add(Box.createVerticalStrut(20));

        RoundedPanel outputCard = new RoundedPanel();

        outputCard.setPreferredSize(new Dimension(700,120));
        outputCard.setMaximumSize(new Dimension(Integer.MAX_VALUE,120));

        outputCard.setLayout(new BorderLayout());
        outputCard.setBorder(new EmptyBorder(20,20,20,20));

        JLabel outputLabel = new JLabel("Output File");
        outputLabel.setFont(Theme.LABEL);

        JPanel row2 = new JPanel(new BorderLayout(10,0));
        row2.setOpaque(false);

        JTextField output = new JTextField();
        JButton browse2 = new JButton("Browse");

        row2.add(output,BorderLayout.CENTER);
        row2.add(browse2,BorderLayout.EAST);

        outputCard.add(outputLabel,BorderLayout.NORTH);
        outputCard.add(row2,BorderLayout.CENTER);

        content.add(outputCard);

        content.add(Box.createVerticalStrut(20));

        RoundedPanel operation = new RoundedPanel();

        operation.setMaximumSize(new Dimension(Integer.MAX_VALUE,180));

        operation.setLayout(new BoxLayout(operation,BoxLayout.Y_AXIS));

        operation.setBorder(new EmptyBorder(20,20,20,20));

        JLabel opLabel = new JLabel("Operation");
        opLabel.setFont(Theme.LABEL);

        String[] options = {
                "Convert",
                "Extract Audio",
                "Trim Video",
                "Resize Video"
        };

        JComboBox<String> combo =
                new JComboBox<>(options);

        combo.setMaximumSize(
                new Dimension(Integer.MAX_VALUE,35));

        JButton execute =
                new JButton("Execute");

        execute.setAlignmentX(Component.CENTER_ALIGNMENT);

        execute.addActionListener(e -> {

    try {

        FFmpegUtil.extractAudio(
                input.getText(),
                output.getText()
        );

        JOptionPane.showMessageDialog(
                this,
                "Audio extracted successfully!"
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

        operation.add(opLabel);
        operation.add(Box.createVerticalStrut(10));
        operation.add(combo);
        operation.add(Box.createVerticalStrut(20));
        operation.add(execute);

        content.add(operation);

        root.add(header,BorderLayout.NORTH);
        root.add(sidebar,BorderLayout.WEST);
        root.add(content,BorderLayout.CENTER);

        setContentPane(root);

    }

    
}