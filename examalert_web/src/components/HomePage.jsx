// import React, { useEffect, useState } from 'react';
// import axios from 'axios';
// import Navbar from './Navbar';
// import { useNavigate } from 'react-router-dom';

// const HomePage = () => {
//   const navigate = useNavigate();
//   const [exams, setExams] = useState([]);

//   useEffect(() => {
//     axios.get('http://localhost:8080/api/exams')
//       .then(res => setExams(res.data))
//       .catch(err => console.error(err));
//   }, []);

//   const upcomingExams = exams.filter(exam => exam.status === 'Upcoming');
//   const allExams = exams;

//   return (
//     <>
//     <Navbar />
//     <div className="container my-5">
//       <h2 className="mb-4">Welcome to Your Exam Dashboard</h2>

//       <div className="row">
//         {/* Upcoming Exams */}
//         <div className="col-md-6 mb-4">
//           <div className="card shadow">
//             <div className="card-body">
//               <h4 className="card-title mb-3">Upcoming Exams</h4>
//               {upcomingExams.length > 0 ? (
//                 <ul className="list-group list-group-flush">
//                   {upcomingExams.map((exam) => (
//                     <li key={exam.id} className="list-group-item">
//                       <div className="d-flex justify-content-between align-items-center">
//                         <div>
//                           <strong>{exam.subject}</strong><br />
//                           {exam.date} at {exam.time}
//                         </div>
//                         <button className="btn btn-primary btn-sm" onClick={() => navigate('/taketest')}>
//                           Join Exam
//                         </button>
//                       </div>
//                     </li>
//                   ))}
//                 </ul>
//               ) : (
//                 <p>No upcoming exams.</p>
//               )}
//             </div>
//           </div>
//         </div>

//         {/* All Exams */}
//         <div className="col-md-6 mb-4">
//           <div className="card shadow">
//             <div className="card-body">
//               <h4 className="card-title mb-3">All Exams</h4>
//               <ul className="list-group list-group-flush">
//                 {allExams.map((exam) => (
//                   <li key={exam.id} className="list-group-item d-flex justify-content-between align-items-center">
//                     {exam.subject}
//                     <span className={`badge bg-${exam.status === 'Completed' ? 'secondary' : 'info'}`}>
//                       {exam.status}
//                     </span>
//                   </li>
//                 ))}
//               </ul>
//             </div>
//           </div>
//         </div>
//       </div>
//     </div>
//     </>
//   );
// };

// export default HomePage;


// import React, { useEffect, useState } from 'react';
// import axios from 'axios';
// import Navbar from './Navbar';
// import { useNavigate } from 'react-router-dom';

// const HomePage = () => {
//   const navigate = useNavigate();
//   const [exams, setExams] = useState([]);
//   const studentEmail = localStorage.getItem('studentEmail'); // Get current student email from local storage

//   useEffect(() => {
//     axios.get('http://localhost:8080/api/exams')
//       .then(res => setExams(res.data))
//       .catch(err => console.error(err));
//   }, []);

//   const handleJoinExam = async (examId) => {
//     try {
//       // 1. Mark the student as joined in DB
//       await axios.post('http://localhost:8080/api/exam-status/join', {
//         examId: examId,
//         email: studentEmail
//       });

//       // 2. Trigger mail to absent students
//       await axios.post(`http://localhost:8080/api/email/notify-absentees`, null, {
//         params: { examId }
//       });

//       // 3. Redirect to the test page
//       navigate('/taketest');
//     } catch (error) {
//       console.error('Error joining exam:', error);
//       alert('Failed to join exam.');
//     }
//   };

//   const upcomingExams = exams.filter(exam => exam.status === 'Upcoming');
//   const allExams = exams;

//   return (
//     <>
//       <Navbar />
//       <div className="container my-5">
//         <h2 className="mb-4">Welcome to Your Exam Dashboard</h2>

//         <div className="row">
//           {/* Upcoming Exams */}
//           <div className="col-md-6 mb-4">
//             <div className="card shadow">
//               <div className="card-body">
//                 <h4 className="card-title mb-3">Upcoming Exams</h4>
//                 {upcomingExams.length > 0 ? (
//                   <ul className="list-group list-group-flush">
//                     {upcomingExams.map((exam) => (
//                       <li key={exam.id} className="list-group-item">
//                         <div className="d-flex justify-content-between align-items-center">
//                           <div>
//                             <strong>{exam.subject}</strong><br />
//                             {exam.date} at {exam.time}
//                           </div>
//                           <button className="btn btn-primary btn-sm" onClick={() => handleJoinExam(exam.id)}>
//                             Join Exam
//                           </button>
//                         </div>
//                       </li>
//                     ))}
//                   </ul>
//                 ) : (
//                   <p>No upcoming exams.</p>
//                 )}
//               </div>
//             </div>
//           </div>

//           {/* All Exams */}
//           <div className="col-md-6 mb-4">
//             <div className="card shadow">
//               <div className="card-body">
//                 <h4 className="card-title mb-3">All Exams</h4>
//                 <ul className="list-group list-group-flush">
//                   {allExams.map((exam) => (
//                     <li key={exam.id} className="list-group-item d-flex justify-content-between align-items-center">
//                       {exam.subject}
//                       <span className={`badge bg-${exam.status === 'Completed' ? 'secondary' : 'info'}`}>
//                         {exam.status}
//                       </span>
//                     </li>
//                   ))}
//                 </ul>
//               </div>
//             </div>
//           </div>
//         </div>
//       </div>
//     </>
//   );
// };

// export default HomePage;

// import React, { useEffect, useState } from 'react';
// import axios from 'axios';
// import Navbar from './Navbar';
// import { useNavigate } from 'react-router-dom';

// const HomePage = () => {
//   const navigate = useNavigate();
//   const [exams, setExams] = useState([]);
//   const studentEmail = localStorage.getItem('email'); // ✅ Get logged-in student email

//   useEffect(() => {
//     axios.get('http://localhost:8080/api/exams')
//       .then(res => setExams(res.data))
//       .catch(err => console.error(err));
//   }, []);

//   const handleJoinExam = async (examId) => {
//     try {
//       await axios.post('http://localhost:8080/api/exam-status/join', {
//         examId: examId,               // ✅ Use passed-in value
//         email: studentEmail           // ✅ matches backend expectation
//       }, {
//         headers: {
//           'Content-Type': 'application/json'
//         }
//       });
  
//       await axios.post('http://localhost:8080/api/email/notify-absentees', null, {
//         params: { examId }
//       });
  
//       navigate('/taketest');
//     } catch (error) {
//       console.error('Error joining exam:', error);
//       alert('Failed to join exam.');
//     }
//   };

//   const upcomingExams = exams.filter(exam => exam.status === 'Upcoming');
//   const allExams = exams;

//   return (
//     <>
//       <Navbar />
//       <div className="container my-5">
//         <h2 className="mb-4">Welcome to Your Exam Dashboard</h2>

//         <div className="row">
//           {/* Upcoming Exams */}
//           <div className="col-md-6 mb-4">
//             <div className="card shadow">
//               <div className="card-body">
//                 <h4 className="card-title mb-3">Upcoming Exams</h4>
//                 {upcomingExams.length > 0 ? (
//                   <ul className="list-group list-group-flush">
//                     {upcomingExams.map((exam) => (
//                       <li key={exam.id} className="list-group-item">
//                         <div className="d-flex justify-content-between align-items-center">
//                           <div>
//                             <strong>{exam.subject}</strong><br />
//                             {exam.date} at {exam.time}
//                           </div>
//                           <button className="btn btn-primary btn-sm" onClick={() => handleJoinExam(exam.id)}>
//                             Join Exam
//                           </button>
//                         </div>
//                       </li>
//                     ))}
//                   </ul>
//                 ) : (
//                   <p>No upcoming exams.</p>
//                 )}
//               </div>
//             </div>
//           </div>

//           {/* All Exams */}
//           <div className="col-md-6 mb-4">
//             <div className="card shadow">
//               <div className="card-body">
//                 <h4 className="card-title mb-3">All Exams</h4>
//                 <ul className="list-group list-group-flush">
//                   {allExams.map((exam) => (
//                     <li key={exam.id} className="list-group-item d-flex justify-content-between align-items-center">
//                       {exam.subject}
//                       <span className={`badge bg-${exam.status === 'Completed' ? 'secondary' : 'info'}`}>
//                         {exam.status}
//                       </span>
//                     </li>
//                   ))}
//                 </ul>
//               </div>
//             </div>
//           </div>
//         </div>
//       </div>
//     </>
//   );
// };

// export default HomePage;

import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Navbar from './Navbar';
import { useNavigate } from 'react-router-dom';

const HomePage = () => {
  const navigate = useNavigate();
  const [exams, setExams] = useState([]);
  const studentEmail = localStorage.getItem('email'); // ✅ Get logged-in student email

  useEffect(() => {
    axios.get('http://localhost:8080/api/exams')
      .then(res => setExams(res.data))
      .catch(err => console.error(err));
  }, []);

  const handleJoinExam = async (examId) => {
    try {
      await axios.post('http://localhost:8080/api/exam-status/join', {
        examId: examId,
        email: studentEmail
      }, {
        headers: {
          'Content-Type': 'application/json'
        }
      });

      await axios.post('http://localhost:8080/api/email/notify-absentees', null, {
        params: { examId }
      });

      navigate('/taketest');
    } catch (error) {
      console.error('Error joining exam:', error);
      alert('Failed to join exam.');
    }
  };

  const upcomingExams = exams.filter(exam => exam.status === 'Upcoming');
  const completedExams = exams.filter(exam => exam.status === 'Completed');

  return (
    <>
      <Navbar />
      <div className="container my-5">
        <h2 className="mb-4">Welcome to Your Exam Dashboard</h2>

        <div className="row">
          {/* Upcoming Exams */}
          <div className="col-md-6 mb-4">
            <div className="card shadow">
              <div className="card-body">
                <h4 className="card-title mb-3">Upcoming Exams</h4>
                {upcomingExams.length > 0 ? (
                  <ul className="list-group list-group-flush">
                    {upcomingExams.map((exam) => (
                      <li key={exam.id} className="list-group-item">
                        <div className="d-flex justify-content-between align-items-center">
                          <div>
                            <strong>{exam.subject}</strong><br />
                            {exam.date} at {exam.time}
                          </div>
                          <button
                            className="btn btn-primary btn-sm"
                            onClick={() => handleJoinExam(exam.id)}
                          >
                            Join Exam
                          </button>
                        </div>
                      </li>
                    ))}
                  </ul>
                ) : (
                  <p>No upcoming exams.</p>
                )}
              </div>
            </div>
          </div>

          {/* Completed Exams */}
          <div className="col-md-6 mb-4">
            <div className="card shadow">
              <div className="card-body">
                <h4 className="card-title mb-3">Completed Exams</h4>
                {completedExams.length > 0 ? (
                  <ul className="list-group list-group-flush">
                    {completedExams.map((exam) => (
                      <li key={exam.id} className="list-group-item">
                        <strong>{exam.subject}</strong><br />
                        {exam.date} at {exam.time}
                      </li>
                    ))}
                  </ul>
                ) : (
                  <p>No completed exams yet.</p>
                )}
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default HomePage;
