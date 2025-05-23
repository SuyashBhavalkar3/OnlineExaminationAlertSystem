import React, { useState } from "react";
import axios from "axios";

function Admin() {
  const [isSignup, setIsSignup] = useState(false);
  const [email, setEmail] = useState("");
  const [grNo, setGrNo] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const endpoint = isSignup
        ? "http://localhost:8080/api/admin/signup"
        : "http://localhost:8080/api/admin/login";

      const payload = isSignup
        ? { grNo, email, password }
        : { email, password };

      const response = await axios.post(endpoint, payload);
      setMessage(response.data);
    } catch (error) {
      console.error(error);
      setMessage("Something went wrong. Please try again.");
    }
  };

  return (
    <div style={{ maxWidth: "400px", margin: "0 auto", paddingTop: "50px" }}>
      <h2>{isSignup ? "Admin Signup" : "Admin Login"}</h2>
      <form onSubmit={handleSubmit}>
        {isSignup && (
          <div>
            <label>GR Number:</label>
            <input
              type="text"
              value={grNo}
              onChange={(e) => setGrNo(e.target.value)}
              required
            />
          </div>
        )}
        <div>
          <label>Email:</label>
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>

        <div>
          <label>Password:</label>
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>

        <button type="submit">{isSignup ? "Signup" : "Login"}</button>
      </form>

      <p>
        {isSignup
          ? "Already have an account?"
          : "Don't have an account?"}{" "}
        <button onClick={() => setIsSignup(!isSignup)}>
          {isSignup ? "Login" : "Signup"}
        </button>
      </p>

      {message && <p>{message}</p>}
    </div>
  );
}

export default Admin;
