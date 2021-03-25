package com.gb.adudarev.level3.lesson2;

import java.sql.*;

public class MainClassLevel3Lesson2 {

    public static Connection connection;
    public static Statement statement;

    public static void main(String[] args) {
        connection();
        createTable("students");
        insertIntoTable("students", "Alexey", "30");
        selectFromTable("students");
        deleteRowTable("students", 1);
        dropTable("students");
        disconnect();
    }

    public static void connection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:./src/com/gb/adudarev/level3/lesson2/main.db");
            statement = connection.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }

    //    1 метод создани таблицы
    public static void createTable(String name) {
        try {
            statement.executeUpdate("CREATE TABLE " + name + " (\n" +
                    "    id    INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    name  TEXT,\n" +
                    "    score INTEGER\n" +
                    ");");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    //    2 метод для добавления записи
    public static void insertIntoTable(String name, String var1, String var2) {
        try {
            statement.executeUpdate("INSERT INTO " + name + " (name,score) VALUES ('" + var1 + "'," + var2 + ")");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    //    3 метод для получения записи
    public static void selectFromTable(String name) {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM " + name + ";");
            while (rs.next()) {
                System.out.println(rs.getString("id") + " " + rs.getString("name") + " " + rs.getString("score"));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    //    4 метод для удаления записи
    public static void deleteRowTable(String name, int id) {
        try {
            statement.executeUpdate("   DELETE FROM " + name + " WHERE id = '" + id + "';");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    //    5 удаление таблицы
    public static void dropTable(String name) {
        try {
            statement.executeUpdate("DROP TABLE " + name + "");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}