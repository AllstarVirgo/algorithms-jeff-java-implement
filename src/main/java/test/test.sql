select distince id,name from student,
    (select distinct score_relation.student_no from score_relation where course_no in
        (select course_no from score_relation where id = 7)) b
where student.id = b.student_no order by id;