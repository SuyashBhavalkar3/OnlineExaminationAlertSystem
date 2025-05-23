import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Navbar from './Navbar';
import axios from 'axios';

const LoginPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [isAdmin, setIsAdmin] = useState(false); // 👈 for admin toggle
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      const url = isAdmin 
        ? 'http://localhost:8080/api/admin/login' // 👈 admin endpoint
        : 'http://localhost:8080/api/login'; // 👈 student endpoint

      const res = await axios.post(url, {
        email,
        password
      });

      if (res.status === 200) {
        navigate(isAdmin ? '/admin/home' : '/home'); // 👈 conditional redirect
      }
    } catch (err) {
      alert('Invalid credentials or server error.');
    }
  };

  return (
    <>
    <Navbar /> 
    <div className="container d-flex align-items-center justify-content-center vh-100">
      <div className="card p-4 shadow" style={{ width: '100%', maxWidth: '400px' }}>
        <h3 className="text-center mb-4">{isAdmin ? 'Admin' : 'Student'} Login</h3>
        <form onSubmit={handleLogin}>
          <div className="mb-3">
            <label className="form-label">Email ID</label>
            <input type="email" className="form-control" value={email}
              onChange={(e) => setEmail(e.target.value)} required />
          </div>
          <div className="mb-3">
            <label className="form-label">Password</label>
            <input type="password" className="form-control" value={password}
              onChange={(e) => setPassword(e.target.value)} required />
          </div>
          <div className="form-check mb-3">
            <input
              className="form-check-input"
              type="checkbox"
              checked={isAdmin}
              onChange={() => setIsAdmin(!isAdmin)}
              id="adminCheck"
            />
            <label className="form-check-label" htmlFor="adminCheck">
              Login as Admin
            </label>
          </div>
          <button type="submit" className="btn btn-primary w-100">Sign In</button>
        </form>
        {!isAdmin && (
          <div className="text-center mt-3">
            Don't have an account?{' '}
            <button className="btn btn-link p-0" onClick={() => navigate('/signup')}>
              Sign up
            </button>
          </div>
        )}
      </div>
    </div>
    </>
  );
};

export default LoginPage;
