// import React, { useEffect, useState } from 'react';
// import { useParams } from 'react-router-dom';
// import axios from 'axios';
// import Navbar from './Navbar';

// const Reports = () => {
//   const { examId } = useParams();
//   const [reportData, setReportData] = useState([]);
//   const [examDetails, setExamDetails] = useState(null);
//   const [loading, setLoading] = useState(true);

//   useEffect(() => {
//     const fetchReport = async () => {
//       try {
//         const [reportRes, examRes] = await Promise.all([
//           axios.get(`http://localhost:8080/api/admin/exams/${examId}/report`),
//           //axios.get(`http://localhost:8080/api/admin/exams/${examId}`) // Optional for exam title/date
//         ]);
//         setReportData(reportRes.data);
//         setExamDetails(examRes.data);
//         setLoading(false);
//       } catch (error) {
//         console.error('Error fetching report:', error);
//         setLoading(false);
//       }
//     };

//     fetchReport();
//   }, [examId]);

//   if (loading) {
//     return <div className="text-center mt-5">Loading report...</div>;
//   }

//   return (
//     <>
//       <Navbar />
//       <div className="container mt-5">
//         <h3 className="mb-4">
//           Report for Exam: <strong>{examDetails?.subject}</strong> <br />
//           <small className="text-muted">
//             {new Date(examDetails?.date + 'T' + examDetails?.time).toLocaleString()}
//           </small>
//         </h3>

//         {reportData.length > 0 ? (
//           <table className="table table-striped">
//             <thead>
//               <tr>
//                 <th>Student Name</th>
//                 <th>Email</th>
//                 <th>Status</th>
//               </tr>
//             </thead>
//             <tbody>
//               {reportData.map((student, index) => (
//                 <tr key={index}>
//                   <td>{student.studentName}</td>
//                   <td>{student.email}</td>
//                   <td>
//                     <span className={`badge bg-${student.status === 'Present' ? 'success' : 'danger'}`}>
//                       {student.status}
//                     </span>
//                   </td>
//                 </tr>
//               ))}
//             </tbody>
//           </table>
//         ) : (
//           <p>No report data available for this exam.</p>
//         )}
//       </div>
//     </>
//   );
// };

// export default Reports;


import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import Navbar from './Navbar';

const Reports = () => {
  const { examId } = useParams();
  const [reportData, setReportData] = useState([]);
  const [examDetails, setExamDetails] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchReport = async () => {
      try {
        const reportRes = await axios.get(`http://localhost:8080/api/admin/exams/${examId}/report`);
        setReportData(reportRes?.data || []);

        // Optional exam details call
        try {
          const examRes = await axios.get(`http://localhost:8080/api/admin/exams/${examId}`);
          setExamDetails(examRes?.data || null);
        } catch (err) {
          console.warn('Could not fetch exam details:', err);
          setExamDetails(null);
        }

        setLoading(false);
      } catch (err) {
        console.error('Error fetching report:', err);
        setError('Failed to fetch report data. Please try again later.');
        setLoading(false);
      }
    };

    fetchReport();
  }, [examId]);

  if (loading) {
    return <div className="text-center mt-5">Loading report...</div>;
  }

  if (error) {
    return (
      <div className="container mt-5">
        <Navbar />
        <div className="alert alert-danger">{error}</div>
      </div>
    );
  }

  return (
    <>
      <Navbar />
      <div className="container mt-5">
        {examDetails && (
          <h3 className="mb-4">
            Report for Exam: <strong>{examDetails.subject}</strong>
            <br />
            <small className="text-muted">
              {new Date(`${examDetails.date}T${examDetails.time}`).toLocaleString()}
            </small>
          </h3>
        )}

        {reportData.length > 0 ? (
          <table className="table table-striped">
            <thead>
              <tr>
                <th>Student Name</th>
                <th>Email</th>
                <th>Status</th>
              </tr>
            </thead>
            <tbody>
              {reportData.map((student, index) => (
                <tr key={index}>
                  <td>{student_.studentName}</td>
                  <td>{student_.email}</td>
                  <td>
                    <span className={`badge bg-${student.status === 'Present' ? 'success' : 'danger'}`}>
                      {student.status}
                    </span>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        ) : (
          <p>No report data available for this exam.</p>
        )}
      </div>
    </>
  );
};

export default Reports;
