import { useState } from "react";
import axios from "axios";
import DotBackground from "../components/DotBackground";

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
      <div className="flex items-center justify-center w-full bg-transparent">
        <div className="bg-transparent p-8 rounded-lg shadow-md w-full max-w-md backdrop-blur-md">
          <h2 className="text-2xl font-bold mb-6 text-center">Login</h2>
          <form onSubmit={handleSubmit} className="space-y-4">
            <div>
              <label className="block mb-1 font-medium">Email</label>
              <input
                type="email"
                className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />
            </div>
            <div>
              <label className="block mb-1 font-medium">Password</label>
              <input
                type="password"
                className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </div>
            {error && <p className="text-red-500 text-sm">{error}</p>}
            <button
              type="submit"
              className="w-full bg-blue-600 text-white py-2 rounded-md hover:bg-blue-700 transition"
            >
              Log In
            </button>
          </form>
        </div>
      </div>
    </DotBackground>
  );
}
