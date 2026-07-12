-- Select the required columns
SELECT
    s.student_id,
    s.student_name,
    sub.subject_name,
    
    -- Count how many times the student attended this subject's exam
    COUNT(e.student_id) AS attended_exams

-- Start with the Students table
FROM Students s

-- Create every possible (student, subject) combination
CROSS JOIN Subjects sub

-- Match each student-subject pair with the Examinations table
LEFT JOIN Examinations e
    ON s.student_id = e.student_id
   AND sub.subject_name = e.subject_name

-- Group by each unique student and subject
GROUP BY
    s.student_id,
    s.student_name,
    sub.subject_name

-- Sort the output as required
ORDER BY
    s.student_id,
    sub.subject_name;