package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();

    public View(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    // Проверка возможности отменить действие
    public boolean canUndo() {
        return false;//return undoManager.canUndo();
    }

    //Проверка возможности перейти на действие вперед
    public boolean canRedo() {
        return false;//return undoManager.canRedo();
    }

    public void init(){
        initGui();
        FrameListener listener = new FrameListener(this);
        addWindowListener(listener);
        setVisible(true);
    }

    public void exit(){
        controller.exit();
    }

    public void initMenuBar(){
        JMenuBar jMenuBar = new JMenuBar();

        MenuHelper.initFileMenu(this, jMenuBar); //file
        MenuHelper.initEditMenu(this, jMenuBar); // edit
        MenuHelper.initStyleMenu(this, jMenuBar); //style
        MenuHelper.initAlignMenu(this, jMenuBar); // align
        MenuHelper.initColorMenu(this, jMenuBar); //colorFont
        MenuHelper.initFontMenu(this, jMenuBar); // fonts
        MenuHelper.initHelpMenu(this, jMenuBar); //help

        getContentPane().add(jMenuBar, BorderLayout.NORTH);

    }
    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane scrollPaneHtml = new JScrollPane(htmlTextPane);
//        htmlTextPane.add(scrollPaneHtml);
        tabbedPane.addTab("HTML",scrollPaneHtml);

        JScrollPane scrollPaneText = new JScrollPane(plainTextPane);
//        plainTextPane.add(scrollPaneText);
        tabbedPane.addTab("Текст",scrollPaneText);
        tabbedPane.setPreferredSize(new Dimension(600, 600));
        TabbedPaneChangeListener listener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(listener);
        getContentPane().add(tabbedPane,BorderLayout.CENTER);
    }

    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged(){}
}
