import { useState } from "react";
import axios from "axios";
import DotBackground from "../components/DotBackground";
import "../styles/login-animated.css";

export default function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");

    try {
      const response = await axios.post("http://backend:8080/api/auth/login", {
        email,
        password,
      });

      const token = response.data.token;
      localStorage.setItem("jwt", token);
      alert("Login successful!");
    } catch (err) {
      setError("Invalid email or password.");
    }
  };

  return (
    <DotBackground>
      <div className="flex items-center justify-center min-h-screen px-4">
        <form onSubmit={handleSubmit} className="login-box">
          <h2
            className="text-3xl font-bold mb-6 font-[Inter]"
            style={{ color: "#261E36" }}
          >
            Welcome Back to JobBoard
          </h2>

          <div className="user-box">
            <input
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
            <label>Email</label>
          </div>

          <div className="user-box">
            <input
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
            <label>Password</label>
          </div>

          {error && <p className="text-red-400 text-sm mb-4">{error}</p>}

          <div className="flex justify-center">
            <button type="submit">Login</button>
          </div>
        </form>
      </div>
    </DotBackground>
  );
}
