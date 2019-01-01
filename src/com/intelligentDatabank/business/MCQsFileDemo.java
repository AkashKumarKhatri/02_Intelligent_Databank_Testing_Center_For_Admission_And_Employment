/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelligentDatabank.business;

import com.intelligentDatabank.dao.AnswerDAO;
import com.intelligentDatabank.dao.QuestionDAO;
import com.intelligentDatabank.dao.impl.AnswerDAOImpl;
import com.intelligentDatabank.dao.impl.QuestionDAOImpl;
import com.intelligentDatabank.models.AnswerModel;
import com.intelligentDatabank.models.QuestionModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Akash
 */
public class MCQsFileDemo {
    static boolean endsWithQMark;
    static String questionLine[];
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("C:\\Users\\Akash\\Desktop\\mcq.txt");
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            QuestionDAO questionDAO = new QuestionDAOImpl();
            AnswerDAO answerDAO = new AnswerDAOImpl();
            QuestionModel questionModel;
            AnswerModel answerModel;
            int row = 0;
            String previousQues = null;
            
            String currentLine;
            while((currentLine = reader.readLine())!=null) {
                endsWithQMark = currentLine.endsWith("?;");
                if(endsWithQMark == true) {
                    questionLine = currentLine.split("\\?;");
                    for (String string : questionLine) {
                        System.out.println(string);
                        questionModel = new QuestionModel();
                        questionModel.setQuestion(string);
                        row = questionDAO.addQuestion(questionModel);
                        previousQues = string;
                    }
                }
                if(endsWithQMark == false && currentLine.isEmpty() == false && row > 0 && previousQues!=null) {
                    questionModel = questionDAO.getQuestionIdByQuestion(previousQues);
                    answerModel = new AnswerModel();
                    answerModel.setAnswer(currentLine);
                    answerModel.setQuestionModel(questionModel);
                    int row1 = answerDAO.addAnswer(answerModel);
                    if(row1>0) {
                        System.out.println("added");
                    }
                    else {
                        System.out.println("Not Added");
                    }
                }
            }
        }
    }
}