package com.principlesofsecurityengineering.project

import javax.swing.JFrame
import javax.swing.JTextArea
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.text.SimpleDateFormat

def frame = new JFrame("Key Press Detection")
def textArea = new JTextArea()
frame.add(textArea)

def date = new Date()
def dateFormat = new SimpleDateFormat("dd-MM-YYYY_HH-mm-ss")
def finalDate = dateFormat.format(date)

def fileName = "KeyLogger_"+finalDate+".txt"

def filePath = "C:\\Users\\saadu\\Desktop\\Online Learning\\Groovy\\KeyStrokes"

def file = new File(filePath,fileName)
file.createNewFile()
def fileWriter = new FileWriter(file)


frame.addKeyListener(new KeyListener() {
    @Override
    void keyTyped(KeyEvent e) {
        def keyChar = e.getKeyChar()
        textArea.append("$keyChar\n")
        fileWriter.write(e.keyChar.toString())
        fileWriter.flush()
    }

    @Override
    void keyPressed(KeyEvent e) {
        def keyCode = e.getKeyCode()
        //textArea.append("Key Pressed: $keyCode\n")
    }

    @Override
    void keyReleased(KeyEvent e) {
        def keyCode = e.getKeyCode()
        //textArea.append("Key Released: $keyCode\n")
    }
})

frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
frame.setSize(400, 200)
frame.visible = true
frame.requestFocus()
