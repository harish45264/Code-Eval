import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Homepage from "./Homepage";
import Playground from "./Playground";
import Login from "./Loginpage";
import SignUp from "./Signuppage";
import Test from "./test";
// import Problems from "./Problems";
// import Courses from "./Courses";
// import Contests from "./Contests";

export default function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Homepage />} />
        <Route path="/playground" element={<Playground />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/test" element={<Test />} />
        {/* <Route path="/problems" element={<Problems />} />
        <Route path="/courses" element={<Courses />} />
        <Route path="/contests" element={<Contests />} /> */}
      </Routes>
    </Router>
  );
}