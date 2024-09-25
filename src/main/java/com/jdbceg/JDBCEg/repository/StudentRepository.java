package com.jdbceg.JDBCEg.repository;

import com.jdbceg.JDBCEg.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbc;

    public void saveStudentInRepository(Student student) {
        //System.out.println("Student added");
        String query = "insert into student (id, name, marks) values (?,?,?)";
        // update return int value
        int rows = jdbc.update(query, student.getId() , student.getName(), student.getMarks()); // is actually executeUpdate for CUD not R
        // question marks replaced by actual values are in Student object
        System.out.println("Total number of rows added:-"+ " " + rows);
        // still we get an error since table not created. Gotta ask H2 to create table
        // we have DMBS - h2 and DB
    }
    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Student> findAllStudents() {
//        List<Student> students = new ArrayList<>();
//        return students;


        // fetc hing the data that was stired

        String query ="select *from student";
        // to execute read and not CUD use executeQuery but we have query
//        RowMapper<Student> mapper = new RowMapper<Student>() {
//            @Override
//            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//                //We will only use ResultSet one row at a time
//                Student student = new Student();
//                student.setId(rs.getInt("id"));
//                student.setName(rs.getString("name"));
//                student.setMarks(rs.getInt("marks"));
//                return student;
//                // taking the data adding to student object and return the object
//            }
//        };
        // RowMapper is a functional interface. We gotta implement mappedRow
        // (ResultSelt (data we get from result set. gives one row at a time), rowNum (mapRow uses behind the scne)

        // making below lamda expresiion
        //return jdbc.query(query, mapper);  // second param is RowMapper object

        return jdbc.query(query, (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setMarks(rs.getInt("marks"));
            return student;
        });

        // Rowmapper we can fetch data from ResultSet
        // in jdbc when we use selectQuery, we get data in ResultSet
        // in the Result we have al;l the data. We get data one by one and row mapper helps us to fetch that data

        // query returns the list of type( here type student)
        // mapper has list of students so using return statement
    }

    // to store the data in h2 db we need jdbc template ( to save data )

    // H2 is a in memory DB. It is embedded DB it knows where H2 is and what configs are required.
    // if external DBMS might not work like postgres. Need config changes
}
