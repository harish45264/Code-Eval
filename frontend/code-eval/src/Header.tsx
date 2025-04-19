import { Link } from "react-router-dom";

export default function Header() {
  return (
    <header className="bg-white shadow">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="flex justify-between h-16">
          <div className="flex">
            <div className="flex-shrink-0 flex items-center">
              <Link to="/" className="font-bold text-xl text-blue-600">
                CodeEval
              </Link>
            </div>
            <nav className="ml-6 flex space-x-8">
              <Link to="/problems" className="inline-flex items-center px-1 pt-1 text-gray-500 hover:text-gray-700">
                Problems
              </Link>
              <Link to="/courses" className="inline-flex items-center px-1 pt-1 text-gray-500 hover:text-gray-700">
                Courses
              </Link>
              <Link to="/contests" className="inline-flex items-center px-1 pt-1 text-gray-500 hover:text-gray-700">
                Contests
              </Link>
              <Link to="/playground" className="inline-flex items-center px-1 pt-1 text-gray-500 hover:text-gray-700">
                Playground
              </Link>
            </nav>
          </div>
          <div className="flex items-center">
            <Link to="/login" className="text-gray-500 hover:text-gray-700 px-3 py-2 rounded-md">
              Login
            </Link>
            <Link to="/signup" className="ml-4 px-4 py-2 rounded-md text-white bg-blue-600 hover:bg-blue-700">
              Sign Up
            </Link>
          </div>
        </div>
      </div>
    </header>
  );
}