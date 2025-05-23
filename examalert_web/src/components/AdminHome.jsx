// import React, { useEffect, useState } from 'react';
// import Navbar from './Navbar';
// import axios from 'axios';

// const AdminHome = () => {
//   const [exams, setExams] = useState([]);

//   useEffect(() => {
//     const fetchExams = async () => {
//       const res = await axios.get('http://localhost:8080/api/admin/exams');
//       setExams(res.data);
//     };
//     fetchExams();
//   }, []);

//   const handleNotify = async (id) => {
//     try {
//       await axios.post(`http://localhost:8080/api/admin/exams/${id}/notify`);
//       alert('Email notification sent successfully!');
//     } catch (error) {
//       alert('Failed to send email notifications.');
//       console.error(error);
//     }
//   };

//   return (
//     <>
//       <Navbar />
//     <div className="container mt-5">
//       <h2 className="mb-4">All Exams</h2>
//       <table className="table">
//         <thead>
//           <tr>
//             <th>Subject</th>
//             <th>Date</th>
//             <th>Time</th>
//             <th>Status</th>
//             <th>Notify</th>
//           </tr>
//         </thead>
//         <tbody>
//           {exams.map((exam) => (
//             <tr key={exam.id}>
//               <td>{exam.subject}</td>
//               {/* <td>{exam.exam_date}</td>
//               <td>{exam.exam_time}</td> */}
//               <td>{new Date(exam.date + 'T' + exam.time).toLocaleDateString()}</td>
//               <td>{new Date(exam.date + 'T' + exam.time).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })}</td>

//               {/* <td>{exam.date}</td>
//               <td>{exam.time}</td> */}
//               <td>{exam.status}</td>
//               <td>
//                 <button
//                   className="btn btn-warning"
//                   onClick={() => handleNotify(exam.id)}
//                 >
//                   Notify through Gmail
//                 </button>
//               </td>
//             </tr>
//           ))}
//         </tbody>
//       </table>
//     </div>
//     </>
//   );
// };

// export default AdminHome;


// import React, { useEffect, useState } from 'react';
// import Navbar from './Navbar';
// import axios from 'axios';

// const AdminHome = () => {
//   const [exams, setExams] = useState([]);

//   useEffect(() => {
//     const fetchExams = async () => {
//       const res = await axios.get('http://localhost:8080/api/admin/exams');
//       setExams(res.data);
//     };
//     fetchExams();
//   }, []);

//   const handleNotify = async (id) => {
//     try {
//       await axios.post(`http://localhost:8080/api/admin/exams/${id}/notify`);
//       alert('Email notification sent successfully!');
//     } catch (error) {
//       alert('Failed to send email notifications.');
//       console.error(error);
//     }
//   };

//   const upcomingExams = exams.filter(exam => exam.status === 'Upcoming');
//   const completedExams = exams.filter(exam => exam.status === 'Completed');

//   return (
//     <>
//       <Navbar />
//       <div className="container mt-5">
//         <h2 className="mb-4">Admin Exam Dashboard</h2>

//         {/* ✅ Upcoming Exams */}
//         <div className="mb-5">
//           <h4>Upcoming Exams</h4>
//           {upcomingExams.length > 0 ? (
//             <table className="table table-bordered">
//               <thead>
//                 <tr>
//                   <th>Subject</th>
//                   <th>Date</th>
//                   <th>Time</th>
//                   <th>Status</th>
//                   <th>Notify</th>
//                 </tr>
//               </thead>
//               <tbody>
//                 {upcomingExams.map((exam) => (
//                   <tr key={exam.id}>
//                     <td>{exam.subject}</td>
//                     <td>{new Date(exam.date + 'T' + exam.time).toLocaleDateString()}</td>
//                     <td>{new Date(exam.date + 'T' + exam.time).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })}</td>
//                     <td>{exam.status}</td>
//                     <td>
//                       <button className="btn btn-warning" onClick={() => handleNotify(exam.id)}>
//                         Notify through Gmail
//                       </button>
//                     </td>
//                   </tr>
//                 ))}
//               </tbody>
//             </table>
//           ) : (
//             <p>No upcoming exams found.</p>
//           )}
//         </div>

//         {/* ✅ Completed Exams */}
//         <div>
//           <h4>Completed Exams</h4>
//           {completedExams.length > 0 ? (
//             <table className="table table-bordered">
//               <thead>
//                 <tr>
//                   <th>Subject</th>
//                   <th>Date</th>
//                   <th>Time</th>
//                   <th>Status</th>
//                 </tr>
//               </thead>
//               <tbody>
//                 {completedExams.map((exam) => (
//                   <tr key={exam.id}>
//                     <td>{exam.subject}</td>
//                     <td>{new Date(exam.date + 'T' + exam.time).toLocaleDateString()}</td>
//                     <td>{new Date(exam.date + 'T' + exam.time).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })}</td>
//                     <td>{exam.status}</td>
//                   </tr>
//                 ))}
//               </tbody>
//             </table>
//           ) : (
//             <p>No completed exams yet.</p>
//           )}
//         </div>
//       </div>
//     </>
//   );
// };

// export default AdminHome;

// import React, { useEffect, useState } from 'react';
// import Navbar from './Navbar';
// import axios from 'axios';
// import { useNavigate } from 'react-router-dom';

// const AdminHome = () => {
//   const [exams, setExams] = useState([]);
//   const navigate = useNavigate();

//   useEffect(() => {
//     const fetchExams = async () => {
//       const res = await axios.get('http://localhost:8080/api/admin/exams');
//       setExams(res.data);
//     };
//     fetchExams();
//   }, []);

//   const handleNotify = async (id) => {
//     try {
//       await axios.post(`http://localhost:8080/api/admin/exams/${id}/notify`);
//       alert('Email notification sent successfully!');
//     } catch (error) {
//       alert('Failed to send email notifications.');
//       console.error(error);
//     }
//   };

//   const handleViewReport = (examId) => {
//     navigate(`/report/${examId}`);
//   };

//   const upcomingExams = exams.filter(exam => exam.status === 'Upcoming');
//   const completedExams = exams.filter(exam => exam.status === 'Completed');

//   return (
//     <>
//       <Navbar />
//       <div className="container mt-5">
//         <h2 className="mb-4">Admin Exam Dashboard</h2>

//         {/* ✅ Upcoming Exams */}
//         <div className="mb-5">
//           <h4>Upcoming Exams</h4>
//           {upcomingExams.length > 0 ? (
//             <table className="table table-bordered">
//               <thead>
//                 <tr>
//                   <th>Subject</th>
//                   <th>Date</th>
//                   <th>Time</th>
//                   <th>Status</th>
//                   <th>Notify</th>
//                 </tr>
//               </thead>
//               <tbody>
//                 {upcomingExams.map((exam) => (
//                   <tr key={exam.id}>
//                     <td>{exam.subject}</td>
//                     <td>{new Date(exam.date + 'T' + exam.time).toLocaleDateString()}</td>
//                     <td>{new Date(exam.date + 'T' + exam.time).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })}</td>
//                     <td>{exam.status}</td>
//                     <td>
//                       <button className="btn btn-warning" onClick={() => handleNotify(exam.id)}>
//                         Notify through Gmail
//                       </button>
//                     </td>
//                   </tr>
//                 ))}
//               </tbody>
//             </table>
//           ) : (
//             <p>No upcoming exams found.</p>
//           )}
//         </div>

//         {/* ✅ Completed Exams */}
//         <div>
//           <h4>Completed Exams</h4>
//           {completedExams.length > 0 ? (
//             <table className="table table-bordered">
//               <thead>
//                 <tr>
//                   <th>Subject</th>
//                   <th>Date</th>
//                   <th>Time</th>
//                   <th>Status</th>
//                   <th>Report</th>
//                 </tr>
//               </thead>
//               <tbody>
//                 {completedExams.map((exam) => (
//                   <tr key={exam.id}>
//                     <td>{exam.subject}</td>
//                     <td>{new Date(exam.date + 'T' + exam.time).toLocaleDateString()}</td>
//                     <td>{new Date(exam.date + 'T' + exam.time).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })}</td>
//                     <td>{exam.status}</td>
//                     <td>
//                       <button
//                         className="btn btn-info"
//                         onClick={() => handleViewReport(exam.id)}
//                       >
//                         View Report
//                       </button>
//                     </td>
//                   </tr>
//                 ))}
//               </tbody>
//             </table>
//           ) : (
//             <p>No completed exams yet.</p>
//           )}
//         </div>
//       </div>
//     </>
//   );
// };

// export default AdminHome;

// import React, { useEffect, useState } from 'react';
// import Navbar from './Navbar';
// import axios from 'axios';
// import { useNavigate } from 'react-router-dom';

// const AdminHome = () => {
//   const [exams, setExams] = useState([]);
//   const [subject, setSubject] = useState('');
//   const [date, setDate] = useState('');
//   const [time, setTime] = useState('');
//   const navigate = useNavigate();

//   useEffect(() => {
//     fetchExams();
//   }, []);

//   const fetchExams = async () => {
//     const res = await axios.get('http://localhost:8080/api/admin/exams');
//     setExams(res.data);
//   };

//   const handleAddExam = async (e) => {
//     e.preventDefault();

//     if (!subject || !date || !time) {
//       alert('Please fill all fields.');
//       return;
//     }

//     try {
//       await axios.post('http://localhost:8080/api/admin/add-exam', {
//         subject,
//         exam_date: date,
//         exam_time: time
//       });
//       alert('Exam added successfully!');
//       setSubject('');
//       setDate('');
//       setTime('');
//       fetchExams(); // refresh the list
//     } catch (error) {
//       alert('Failed to add exam.');
//       console.error(error);
//     }
//   };

//   const handleNotify = async (id) => {
//     try {
//       await axios.post(`http://localhost:8080/api/admin/exams/${id}/notify`);
//       alert('Email notification sent successfully!');
//     } catch (error) {
//       alert('Failed to send email notifications.');
//       console.error(error);
//     }
//   };

//   const handleViewReport = (examId) => {
//     navigate(`/report/${examId}`);
//   };

//   const upcomingExams = exams.filter(exam => exam.status === 'Upcoming');
//   const completedExams = exams.filter(exam => exam.status === 'Completed');

//   return (
//     <>
//       <Navbar />
//       <div className="container mt-5">
//         <h2 className="mb-4">Admin Exam Dashboard</h2>

//         {/* ✅ Add Exam Form */}
//         <div className="card p-4 mb-4">
//           <h4>Add New Exam</h4>
//           <form onSubmit={handleAddExam}>
//             <div className="row mb-3">
//               <div className="col-md-4">
//                 <input
//                   type="text"
//                   className="form-control"
//                   placeholder="Subject"
//                   value={subject}
//                   onChange={(e) => setSubject(e.target.value)}
//                 />
//               </div>
//               <div className="col-md-4">
//                 <input
//                   type="date"
//                   className="form-control"
//                   value={date}
//                   onChange={(e) => setDate(e.target.value)}
//                 />
//               </div>
//               <div className="col-md-4">
//                 <input
//                   type="time"
//                   className="form-control"
//                   value={time}
//                   onChange={(e) => setTime(e.target.value)}
//                 />
//               </div>
//             </div>
//             <button type="submit" className="btn btn-success">Add Exam</button>
//           </form>
//         </div>

//         {/* ✅ Upcoming Exams */}
//         <div className="mb-5">
//           <h4>Upcoming Exams</h4>
//           {upcomingExams.length > 0 ? (
//             <table className="table table-bordered">
//               <thead>
//                 <tr>
//                   <th>Subject</th>
//                   <th>Date</th>
//                   <th>Time</th>
//                   <th>Status</th>
//                   <th>Notify</th>
//                 </tr>
//               </thead>
//               <tbody>
//                 {upcomingExams.map((exam) => (
//                   <tr key={exam.id}>
//                     <td>{exam.subject}</td>
//                     <td>{new Date(exam.date + 'T' + exam.time).toLocaleDateString()}</td>
//                     <td>{new Date(exam.date + 'T' + exam.time).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })}</td>
//                     <td>{exam.status}</td>
//                     <td>
//                       <button className="btn btn-warning" onClick={() => handleNotify(exam.id)}>
//                         Notify through Gmail
//                       </button>
//                     </td>
//                   </tr>
//                 ))}
//               </tbody>
//             </table>
//           ) : (
//             <p>No upcoming exams found.</p>
//           )}
//         </div>

//         {/* ✅ Completed Exams */}
//         <div>
//           <h4>Completed Exams</h4>
//           {completedExams.length > 0 ? (
//             <table className="table table-bordered">
//               <thead>
//                 <tr>
//                   <th>Subject</th>
//                   <th>Date</th>
//                   <th>Time</th>
//                   <th>Status</th>
//                   <th>Report</th>
//                 </tr>
//               </thead>
//               <tbody>
//                 {completedExams.map((exam) => (
//                   <tr key={exam.id}>
//                     <td>{exam.subject}</td>
//                     <td>{new Date(exam.date + 'T' + exam.time).toLocaleDateString()}</td>
//                     <td>{new Date(exam.date + 'T' + exam.time).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })}</td>
//                     <td>{exam.status}</td>
//                     <td>
//                       <button className="btn btn-info" onClick={() => handleViewReport(exam.id)}>
//                         View Report
//                       </button>
//                     </td>
//                   </tr>
//                 ))}
//               </tbody>
//             </table>
//           ) : (
//             <p>No completed exams yet.</p>
//           )}
//         </div>
//       </div>
//     </>
//   );
// };

// export default AdminHome;


// import React, { useEffect, useState } from 'react';
// import Navbar from './Navbar';
// import axios from 'axios';
// import { useNavigate } from 'react-router-dom';

// const AdminHome = () => {
//   const [exams, setExams] = useState([]);
//   const [subject, setSubject] = useState('');
//   const [examDate, setExamDate] = useState('');
//   const [examTime, setExamTime] = useState('');
//   const navigate = useNavigate();

//   useEffect(() => {
//     fetchExams();
//   }, []);

//   const fetchExams = async () => {
//     try {
//       const res = await axios.get('http://localhost:8080/api/admin/exams');
//       setExams(res.data);
//     } catch (error) {
//       console.error('Error fetching exams:', error);
//     }
//   };

//   const handleAddExam = async (e) => {
//     e.preventDefault();
  
//     if (!subject || !date || !time) {
//       alert('Please fill all fields.');
//       return;
//     }
  
//     try {
//       await axios.post('http://localhost:8080/api/admin/exams', {
//         subject,
//         examDate: date,
//         examTime: time
//       });
//       alert('Exam added successfully!');
//       setSubject('');
//       setDate('');
//       setTime('');
//       fetchExams();
//     } catch (error) {
//       alert('Failed to add exam.');
//       console.error(error);
//     }
//   };
  

//   const handleNotify = async (id) => {
//     try {
//       await axios.post(`http://localhost:8080/api/admin/exams/${id}/notify`);
//       alert('Email notification sent successfully!');
//     } catch (error) {
//       alert('Failed to send email notifications.');
//       console.error('Notify Error:', error);
//     }
//   };

//   const handleViewReport = (examId) => {
//     navigate(`/report/${examId}`);
//   };

//   const upcomingExams = exams.filter((exam) => exam.status === 'Upcoming');
//   const completedExams = exams.filter((exam) => exam.status === 'Completed');

//   return (
//     <>
//       <Navbar />
//       <div className="container mt-5">
//         <h2 className="mb-4">Admin Exam Dashboard</h2>

//         {/* ✅ Add Exam Form */}
//         <div className="card p-4 mb-4">
//           <h4>Add New Exam</h4>
//           <form onSubmit={handleAddExam}>
//             <div className="row mb-3">
//               <div className="col-md-4">
//                 <input
//                   type="text"
//                   className="form-control"
//                   placeholder="Subject"
//                   value={subject}
//                   onChange={(e) => setSubject(e.target.value)}
//                 />
//               </div>
//               <div className="col-md-4">
//                 <input
//                   type="date"
//                   className="form-control"
//                   value={examDate}
//                   onChange={(e) => setExamDate(e.target.value)}
//                 />
//               </div>
//               <div className="col-md-4">
//                 <input
//                   type="time"
//                   className="form-control"
//                   value={examTime}
//                   onChange={(e) => setExamTime(e.target.value)}
//                 />
//               </div>
//             </div>
//             <button type="submit" className="btn btn-success">Add Exam</button>
//           </form>
//         </div>

//         {/* ✅ Upcoming Exams */}
//         <div className="mb-5">
//           <h4>Upcoming Exams</h4>
//           {upcomingExams.length > 0 ? (
//             <table className="table table-bordered">
//               <thead>
//                 <tr>
//                   <th>Subject</th>
//                   <th>Date</th>
//                   <th>Time</th>
//                   <th>Status</th>
//                   <th>Notify</th>
//                 </tr>
//               </thead>
//               <tbody>
//                 {upcomingExams.map((exam) => (
//                   <tr key={exam.id}>
//                     <td>{exam.subject}</td>
//                     <td>{new Date(exam.exam_date + 'T' + exam.exam_time).toLocaleDateString()}</td>
//                     <td>{new Date(exam.exam_date + 'T' + exam.exam_time).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })}</td>
//                     <td>{exam.status}</td>
//                     <td>
//                       <button className="btn btn-warning" onClick={() => handleNotify(exam.id)}>
//                         Notify through Gmail
//                       </button>
//                     </td>
//                   </tr>
//                 ))}
//               </tbody>
//             </table>
//           ) : (
//             <p>No upcoming exams found.</p>
//           )}
//         </div>

//         {/* ✅ Completed Exams */}
//         <div>
//           <h4>Completed Exams</h4>
//           {completedExams.length > 0 ? (
//             <table className="table table-bordered">
//               <thead>
//                 <tr>
//                   <th>Subject</th>
//                   <th>Date</th>
//                   <th>Time</th>
//                   <th>Status</th>
//                   <th>Report</th>
//                 </tr>
//               </thead>
//               <tbody>
//                 {completedExams.map((exam) => (
//                   <tr key={exam.id}>
//                     <td>{exam.subject}</td>
//                     <td>{new Date(exam.exam_date + 'T' + exam.exam_time).toLocaleDateString()}</td>
//                     <td>{new Date(exam.exam_date + 'T' + exam.exam_time).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })}</td>
//                     <td>{exam.status}</td>
//                     <td>
//                       <button className="btn btn-info" onClick={() => handleViewReport(exam.id)}>
//                         View Report
//                       </button>
//                     </td>
//                   </tr>
//                 ))}
//               </tbody>
//             </table>
//           ) : (
//             <p>No completed exams yet.</p>
//           )}
//         </div>
//       </div>
//     </>
//   );
// };

// export default AdminHome;


// import React, { useEffect, useState } from 'react';
// import Navbar from './Navbar';
// import axios from 'axios';
// import { useNavigate } from 'react-router-dom';

// const AdminHome = () => {
//   const [exams, setExams] = useState([]);
//   const [subject, setSubject] = useState('');
//   const [examDate, setExamDate] = useState('');
//   const [examTime, setExamTime] = useState('');
//   const navigate = useNavigate();

//   useEffect(() => {
//     fetchExams();
//   }, []);

//   const fetchExams = async () => {
//     try {
//       const res = await axios.get('http://localhost:8080/api/admin/exams');
//       setExams(res.data);
//     } catch (error) {
//       console.error('Error fetching exams:', error);
//     }
//   };

//   const handleAddExam = async (e) => {
//     e.preventDefault();

//     if (!subject || !examDate || !examTime) {
//       alert('Please fill all fields.');
//       return;
//     }

//     try {
//       await axios.post('http://localhost:8080/api/admin/exams', {
//         subject,
//         date,
//         time
//       });
//       alert('Exam added successfully!');
//       setSubject('');
//       setExamDate('');
//       setExamTime('');
//       fetchExams();
//     } catch (error) {
//       alert('Failed to add exam.');
//       console.error(error);
//     }
//   };

//   const handleNotify = async (id) => {
//     try {
//       await axios.post(`http://localhost:8080/api/admin/exams/${id}/notify`);
//       alert('Email notification sent successfully!');
//     } catch (error) {
//       alert('Failed to send email notifications.');
//       console.error(error);
//     }
//   };

//   const handleViewReport = (examId) => {
//     navigate(`/report/${examId}`);
//   };

//   const upcomingExams = exams.filter(exam => exam.status === 'Upcoming');
//   const completedExams = exams.filter(exam => exam.status === 'Completed');

//   return (
//     <>
//       <Navbar />
//       <div className="container mt-5">
//         <h2 className="mb-4">Admin Exam Dashboard</h2>

//         {/* ✅ Add Exam Form */}
//         <div className="card p-4 mb-4">
//           <h4>Add New Exam</h4>
//           <form onSubmit={handleAddExam}>
//             <div className="row mb-3">
//               <div className="col-md-4">
//                 <input
//                   type="text"
//                   className="form-control"
//                   placeholder="Subject"
//                   value={subject}
//                   onChange={(e) => setSubject(e.target.value)}
//                 />
//               </div>
//               <div className="col-md-4">
//                 <input
//                   type="date"
//                   className="form-control"
//                   value={examDate}
//                   onChange={(e) => setExamDate(e.target.value)}
//                 />
//               </div>
//               <div className="col-md-4">
//                 <input
//                   type="time"
//                   className="form-control"
//                   value={examTime}
//                   onChange={(e) => setExamTime(e.target.value)}
//                 />
//               </div>
//             </div>
//             <button type="submit" className="btn btn-success">Add Exam</button>
//           </form>
//         </div>

//         {/* ✅ Upcoming Exams */}
//         <div className="mb-5">
//           <h4>Upcoming Exams</h4>
//           {upcomingExams.length > 0 ? (
//             <table className="table table-bordered">
//               <thead>
//                 <tr>
//                   <th>Subject</th>
//                   <th>Date</th>
//                   <th>Time</th>
//                   <th>Status</th>
//                   <th>Notify</th>
//                 </tr>
//               </thead>
//               <tbody>
//                 {upcomingExams.map((exam) => (
//                   <tr key={exam.id}>
//                     <td>{exam.subject}</td>
//                     <td>{new Date(exam.examDate + 'T' + exam.examTime).toLocaleDateString()}</td>
//                     <td>{new Date(exam.examDate + 'T' + exam.examTime).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })}</td>
//                     <td>{exam.status}</td>
//                     <td>
//                       <button className="btn btn-warning" onClick={() => handleNotify(exam.id)}>
//                         Notify through Gmail
//                       </button>
//                     </td>
//                   </tr>
//                 ))}
//               </tbody>
//             </table>
//           ) : (
//             <p>No upcoming exams found.</p>
//           )}
//         </div>

//         {/* ✅ Completed Exams */}
//         <div>
//           <h4>Completed Exams</h4>
//           {completedExams.length > 0 ? (
//             <table className="table table-bordered">
//               <thead>
//                 <tr>
//                   <th>Subject</th>
//                   <th>Date</th>
//                   <th>Time</th>
//                   <th>Status</th>
//                   <th>Report</th>
//                 </tr>
//               </thead>
//               <tbody>
//                 {completedExams.map((exam) => (
//                   <tr key={exam.id}>
//                     <td>{exam.subject}</td>
//                     <td>{new Date(exam.examDate + 'T' + exam.examTime).toLocaleDateString()}</td>
//                     <td>{new Date(exam.examDate + 'T' + exam.examTime).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })}</td>
//                     <td>{exam.status}</td>
//                     <td>
//                       <button className="btn btn-info" onClick={() => handleViewReport(exam.id)}>
//                         View Report
//                       </button>
//                     </td>
//                   </tr>
//                 ))}
//               </tbody>
//             </table>
//           ) : (
//             <p>No completed exams yet.</p>
//           )}
//         </div>
//       </div>
//     </>
//   );
// };

// export default AdminHome;


import React, { useEffect, useState } from 'react';
import Navbar from './Navbar';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const AdminHome = () => {
  const [exams, setExams] = useState([]);
  const [subject, setSubject] = useState('');
  const [date, setDate] = useState('');
  const [time, setTime] = useState('');
  const navigate = useNavigate();

  useEffect(() => {
    fetchExams();
  }, []);

  const fetchExams = async () => {
    try {
      const res = await axios.get('http://localhost:8080/api/admin/exams');
  
      // Sort by date and time
      const sortedExams = res.data.sort((a, b) => {
        const dateTimeA = new Date(`${a.date}T${a.time}`);
        const dateTimeB = new Date(`${b.date}T${b.time}`);
        return dateTimeA - dateTimeB;
      });
  
      setExams(sortedExams);
    } catch (error) {
      console.error('Error fetching exams:', error);
    }
  };

  const handleAddExam = async (e) => {
    e.preventDefault();

    if (!subject || !date || !time) {
      alert('Please fill all fields.');
      return;
    }

    try {
      await axios.post('http://localhost:8080/api/admin/exams', {
        subject,
        date,    // ✅ match field in backend entity
        time     // ✅ match field in backend entity
      });
      alert('Exam added successfully!');
      setSubject('');
      setDate('');
      setTime('');
      fetchExams(); // Refresh list
    } catch (error) {
      alert('Failed to add exam.');
      console.error(error.response?.data || error.message);
    }
  };

  const handleNotify = async (id) => {
    try {
      await axios.post(`http://localhost:8080/api/admin/exams/${id}/notify`);
      alert('Email notification sent successfully!');
    } catch (error) {
      alert('Failed to send email notifications.');
      console.error(error);
    }
  };

  const handleViewReport = (examId) => {
    navigate(`/report/${examId}`);
  };

  const upcomingExams = exams.filter(exam => exam.status === 'Upcoming');
  const completedExams = exams.filter(exam => exam.status === 'Completed');

  return (
    <>
      <Navbar />
      <div className="container mt-5">
        <h2 className="mb-4">Admin Exam Dashboard</h2>

        {/* ✅ Add Exam Form */}
        <div className="card p-4 mb-4">
          <h4>Add New Exam</h4>
          <form onSubmit={handleAddExam}>
            <div className="row mb-3">
              <div className="col-md-4">
                <input
                  type="text"
                  className="form-control"
                  placeholder="Subject"
                  value={subject}
                  onChange={(e) => setSubject(e.target.value)}
                />
              </div>
              <div className="col-md-4">
                <input
                  type="date"
                  className="form-control"
                  value={date}
                  onChange={(e) => setDate(e.target.value)}
                />
              </div>
              <div className="col-md-4">
                <input
                  type="time"
                  className="form-control"
                  value={time}
                  onChange={(e) => setTime(e.target.value)}
                />
              </div>
            </div>
            <button type="submit" className="btn btn-success">Add Exam</button>
          </form>
        </div>

        {/* ✅ Upcoming Exams */}
        <div className="mb-5">
          <h4>Upcoming Exams</h4>
          {upcomingExams.length > 0 ? (
            <table className="table table-bordered">
              <thead>
                <tr>
                  <th>Subject</th>
                  <th>Date</th>
                  <th>Time</th>
                  <th>Status</th>
                  <th>Notify</th>
                </tr>
              </thead>
              <tbody>
                {upcomingExams.map((exam) => (
                  <tr key={exam.id}>
                    <td>{exam.subject}</td>
                    <td>{new Date(exam.date + 'T' + exam.time).toLocaleDateString()}</td>
                    <td>{new Date(exam.date + 'T' + exam.time).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })}</td>
                    <td>{exam.status}</td>
                    <td>
                      <button className="btn btn-warning" onClick={() => handleNotify(exam.id)}>
                        Notify through Gmail
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          ) : (
            <p>No upcoming exams found.</p>
          )}
        </div>

        {/* ✅ Completed Exams */}
        <div>
          <h4>Completed Exams</h4>
          {completedExams.length > 0 ? (
            <table className="table table-bordered">
              <thead>
                <tr>
                  <th>Subject</th>
                  <th>Date</th>
                  <th>Time</th>
                  <th>Status</th>
                  <th>Report</th>
                </tr>
              </thead>
              <tbody>
                {completedExams.map((exam) => (
                  <tr key={exam.id}>
                    <td>{exam.subject}</td>
                    <td>{new Date(exam.date + 'T' + exam.time).toLocaleDateString()}</td>
                    <td>{new Date(exam.date + 'T' + exam.time).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })}</td>
                    <td>{exam.status}</td>
                    <td>
                      <button className="btn btn-info" onClick={() => handleViewReport(exam.id)}>
                        View Report
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          ) : (
            <p>No completed exams yet.</p>
          )}
        </div>
      </div>
    </>
  );
};

export default AdminHome;
