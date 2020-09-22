package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

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
        switch (e.getActionCommand()) {
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
        }
    }
    // Проверка возможности отменить действие
    public boolean canUndo() {
        return undoManager.canUndo();
    }

    //Проверка возможности перейти на действие вперед
    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public void init(){
        initGui();
        FrameListener listener = new FrameListener(this);
        addWindowListener(listener);
        setVisible(true);
    }

    //должен сбрасывать все правки в менеджере
    public void resetUndo() {
        undoManager.discardAllEdits();
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

    // геттер для слушателя изменений
    public UndoListener getUndoListener() {
        return undoListener;
    }


    //отменяет последнее действие
    public void undo() {
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            ExceptionHandler.log(e);
        }
    }

    //возвращает ранее отмененное действие
    public void redo() {
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            ExceptionHandler.log(e);
        }
    }

    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();

    }

    // обновляет html страницу
    public void update() {
        htmlTextPane.setDocument(controller.getDocument());
    }


    public boolean isHtmlTabSelected() {
        return tabbedPane.getSelectedIndex() == 0;
    }

    public void selectedTabChanged() {
        switch (tabbedPane.getSelectedIndex()) {
            case 0:
                controller.setPlainText(plainTextPane.getText());
                break;
            case 1:
                plainTextPane.setText(controller.getPlainText());
                break;
        }
        resetUndo();
    }


    // "О программе"
    public void showAbout() {
        JOptionPane.showMessageDialog(getContentPane(), "It hard to be God", "Information", JOptionPane.INFORMATION_MESSAGE);
    }

}
