import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

const SignupPage = () => {
  const [name, setName] = useState('');
  const [prn, setPrn] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [isAdmin, setIsAdmin] = useState(false); // 👈 toggle for admin
  const navigate = useNavigate();

  const handleSignup = async (e) => {
    e.preventDefault();

    try {
      const url = isAdmin
        ? 'http://localhost:8080/api/admin/signup'
        : 'http://localhost:8080/api/students/signup';

      const payload = isAdmin
        ? { grNo: prn, email, password } // 👈 gr_no used for admin
        : { name, prn, email, password };

      const res = await axios.post(url, payload);

      if (res.status === 200) {
        navigate(isAdmin ? '/admin/home' : '/home');
      }
    } catch (err) {
      alert('Signup failed. Try again.');
      console.error(err);
    }
  };

  return (
    <div className="container d-flex align-items-center justify-content-center vh-100">
      <div className="card p-4 shadow" style={{ width: '100%', maxWidth: '400px' }}>
        <h3 className="text-center mb-4">{isAdmin ? 'Admin' : 'Student'} Sign Up</h3>
        <form onSubmit={handleSignup}>
          {!isAdmin && (
            <div className="mb-3">
              <label className="form-label">Name</label>
              <input className="form-control" value={name}
                onChange={(e) => setName(e.target.value)} required />
            </div>
          )}
          <div className="mb-3">
            <label className="form-label">{isAdmin ? 'GR Number' : 'PRN'}</label>
            <input className="form-control" value={prn}
              onChange={(e) => setPrn(e.target.value)} required />
          </div>
          <div className="mb-3">
            <label className="form-label">Email</label>
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
              Sign up as Admin
            </label>
          </div>
          <button type="submit" className="btn btn-primary w-100">Sign Up</button>
        </form>
        <div className="text-center mt-3">
          Already have an account?{' '}
          <button className="btn btn-link p-0" onClick={() => navigate('/')}>
            Login
          </button>
        </div>
      </div>
    </div>
  );
};

export default SignupPage;
