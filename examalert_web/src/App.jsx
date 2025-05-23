import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import LoginPage from './components/LoginPage';
import SignupPage from './components/SignUpPage';
import HomePage from './components/HomePage';
import TestPage from './components/TestPage'; // ← Import this
import Admin from './components/admin'; // ← Import this
import AdminHome from './components/AdminHome'; // ← Import this
import Reports from './components/Reports'; // ← Import this
import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<LoginPage />} />
        <Route path="/signup" element={<SignupPage />} />
        <Route path="/admin" element={<Admin />} />
        <Route path="/home" element={<HomePage />} />
        <Route path="/taketest" element={<TestPage />} /> {/* ← Add this */}
        <Route path="/admin/home" element={<AdminHome />} />
        <Route path="/report/:examId" element={<Reports />} />
      </Routes>
    </Router>
  );
}

export default App;
