import { useState } from "react";
import Header from "./Header";

export default function Playground() {
  const [activeTab, setActiveTab] = useState("question");
  const [selectedLanguage, setSelectedLanguage] = useState("Java");
  const [code, setCode] = useState(`class Solution {
  public boolean hasDuplicate(int[] nums) {
   // add your code here;
}`);

  const languages = ["Java", "Python", "C++"];
  
  // Sample code templates for different languages
  const codeTemplates = {
    "Java": `class Solution {
  public boolean hasDuplicate(int[] nums) {
   // add your code here;
}`,
    "Python": `class Solution:
   // add your code here;`,
    "C++": `class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        // add your code here;
};`
  };

  // Update code when language changes
  const handleLanguageChange = (language) => {
    setSelectedLanguage(language);
    setCode(codeTemplates[language]);
  };

  return (
    <div className="min-h-screen bg-gray-100">
      <Header />
      
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-8">
        <h2 className="text-3xl font-bold mb-6">Code Playground</h2>
        
        <div className="flex flex-col lg:flex-row gap-4 bg-gray-900 rounded-lg overflow-hidden">
          {/* Left panel: Problem statement */}
          <div className="lg:w-2/5 bg-gray-800 text-white p-4">
            <div className="flex border-b border-gray-700 mb-4">
              <button 
                className={`px-4 py-2 ${activeTab === "question" ? "border-b-2 border-blue-500" : ""}`}
                onClick={() => setActiveTab("question")}
              >
                Question
              </button>
              <button 
                className={`px-4 py-2 ${activeTab === "solution" ? "border-b-2 border-blue-500" : ""}`}
                onClick={() => setActiveTab("solution")}
              >
                Solution
              </button>
              <button 
                className={`px-4 py-2 ${activeTab === "submissions" ? "border-b-2 border-blue-500" : ""}`}
                onClick={() => setActiveTab("submissions")}
              >
                Submissions
              </button>
            </div>
            
            {activeTab === "question" && (
              <div className="py-2">
                <div className="flex justify-between items-center mb-2">
                  <h3 className="text-xl font-bold">Contains Duplicate</h3>
                  <span className="text-gray-400">Solved</span>
                </div>
                <span className="inline-block bg-green-600 px-3 py-1 rounded-full text-sm mb-4">Easy</span>
                
                <p className="mb-4">
                  Given an integer array <code className="bg-gray-700 px-1 rounded">nums</code>, return <code className="bg-gray-700 px-1 rounded">true</code> if any value appears <strong>more than once</strong> in the array, otherwise return <code className="bg-gray-700 px-1 rounded">false</code>.
                </p>
                
                <div className="mb-4">
                  <h4 className="font-bold">Example 1:</h4>
                  <div className="bg-gray-700 p-2 rounded mt-2">
                    <p><span className="text-blue-400">Input:</span> nums = [1, 2, 3, 1]</p>
                    <p><span className="text-blue-400">Output:</span> true</p>
                  </div>
                </div>
                
                <div className="mb-4">
                  <h4 className="font-bold">Example 2:</h4>
                  <div className="bg-gray-700 p-2 rounded mt-2">
                    <p><span className="text-blue-400">Input:</span> nums = [1, 2, 3, 4]</p>
                    <p><span className="text-blue-400">Output:</span> false</p>
                  </div>
                </div>
              </div>
            )}
            
            {activeTab === "solution" && (
              <div className="py-2">
                <h3 className="text-xl font-bold mb-4">Solution</h3>
                <p className="mb-4">Here's an efficient solution using a HashSet:</p>
                <pre className="bg-gray-700 p-4 rounded-md overflow-x-auto">
                  <code>
                    {codeTemplates[selectedLanguage]}
                  </code>
                </pre>
                <div className="mt-4">
                  <h4 className="font-bold">Complexity Analysis</h4>
                  <p className="mt-2">Time Complexity: O(n) where n is the length of the array</p>
                  <p>Space Complexity: O(n) for storing elements in the hash set</p>
                </div>
              </div>
            )}
            
            {activeTab === "submissions" && (
              <div className="py-2">
                <h3 className="text-xl font-bold mb-4">Your Submissions</h3>
                <div className="bg-gray-700 p-3 rounded-md mb-3">
                  <div className="flex justify-between items-center">
                    <span className="text-green-400">Accepted</span>
                    <span className="text-sm text-gray-400">19 Apr 2025</span>
                  </div>
                  <div className="mt-2 text-sm">
                    <span>Runtime: 5 ms</span>
                    <span className="ml-4">Memory: 53.2 MB</span>
                  </div>
                </div>
              </div>
            )}
          </div>
          
          {/* Right panel: Code editor */}
          <div className="lg:w-3/5 bg-gray-900 text-white">
            <div className="flex justify-between items-center p-2 border-b border-gray-700">
              <div className="flex">
                <select 
                  className="bg-gray-800 text-white px-3 py-1 rounded-md"
                  value={selectedLanguage}
                  onChange={(e) => handleLanguageChange(e.target.value)}
                >
                  {languages.map((lang) => (
                    <option key={lang} value={lang}>{lang}</option>
                  ))}
                </select>
              </div>
              <div className="flex space-x-2">
                <button className="p-1 text-gray-400 hover:text-white">
                  <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                    <path fillRule="evenodd" d="M11.49 3.17c-.38-1.56-2.6-1.56-2.98 0a1.532 1.532 0 01-2.286.948c-1.372-.836-2.942.734-2.106 2.106.54.886.061 2.042-.947 2.287-1.561.379-1.561 2.6 0 2.978a1.532 1.532 0 01.947 2.287c-.836 1.372.734 2.942 2.106 2.106a1.532 1.532 0 012.287.947c.379 1.561 2.6 1.561 2.978 0a1.533 1.533 0 012.287-.947c1.372.836 2.942-.734 2.106-2.106a1.533 1.533 0 01.947-2.287c1.561-.379 1.561-2.6 0-2.978a1.532 1.532 0 01-.947-2.287c.836-1.372-.734-2.942-2.106-2.106a1.532 1.532 0 01-2.287-.947zM10 13a3 3 0 100-6 3 3 0 000 6z" clipRule="evenodd" />
                  </svg>
                </button>
                <button className="p-1 text-gray-400 hover:text-white">
                  <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                    <path fillRule="evenodd" d="M4 2a1 1 0 011 1v2.101a7.002 7.002 0 0111.601 2.566 1 1 0 11-1.885.666A5.002 5.002 0 005.999 7H9a1 1 0 010 2H4a1 1 0 01-1-1V3a1 1 0 011-1zm.008 9.057a1 1 0 011.276.61A5.002 5.002 0 0014.001 13H11a1 1 0 110-2h5a1 1 0 011 1v5a1 1 0 11-2 0v-2.101a7.002 7.002 0 01-11.601-2.566 1 1 0 01.61-1.276z" clipRule="evenodd" />
                  </svg>
                </button>
                <button className="p-1 text-gray-400 hover:text-white">
                  <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                    <path fillRule="evenodd" d="M3 4a1 1 0 011-1h4a1 1 0 010 2H6.414l2.293 2.293a1 1 0 01-1.414 1.414L5 6.414V8a1 1 0 01-2 0V4zm9 1a1 1 0 010-2h4a1 1 0 011 1v4a1 1 0 01-2 0V6.414l-2.293 2.293a1 1 0 11-1.414-1.414L13.586 5H12zm-9 7a1 1 0 012 0v1.586l2.293-2.293a1 1 0 111.414 1.414L6.414 15H8a1 1 0 010 2H4a1 1 0 01-1-1v-4zm13-1a1 1 0 011 1v4a1 1 0 01-1 1h-4a1 1 0 010-2h1.586l-2.293-2.293a1 1 0 111.414-1.414L15 13.586V12a1 1 0 011-1z" clipRule="evenodd" />
                  </svg>
                </button>
              </div>
            </div>
            
            {/* Code editor content */}
            <div className="p-2 h-64 font-mono text-sm overflow-auto">
              {/* Line numbers */}
              <div className="flex">
                <div className="mr-4 text-gray-500 text-right select-none w-6">
                  {Array.from({ length: code.split('\n').length }).map((_, i) => (
                    <div key={i}>{i + 1}</div>
                  ))}
                </div>
                {/* Code content */}
                <pre className="flex-1 overflow-x-auto">
                  <textarea
                    className="bg-transparent text-white w-full h-full resize-none outline-none font-mono"
                    value={code}
                    onChange={(e) => setCode(e.target.value)}
                    spellCheck="false"
                  />
                </pre>
              </div>
            </div>
            
            {/* Test cases and run buttons */}
            <div className="border-t border-gray-700 p-4">
              <div className="flex justify-between items-center mb-4">
                <div className="flex space-x-2">
                  <button className="px-3 py-1 bg-gray-700 rounded hover:bg-gray-600">Test Case</button>
                  <button className="px-3 py-1 bg-gray-700 rounded hover:bg-gray-600">Output</button>
                </div>
                <div className="flex space-x-2">
                  <button className="px-4 py-1 rounded bg-gray-700 hover:bg-gray-600">Run</button>
                  <button className="px-4 py-1 rounded bg-green-600 hover:bg-green-700">Submit</button>
                </div>
              </div>
              
              <div className="bg-gray-800 p-3 rounded-md">
                <p className="text-green-500 font-semibold mb-2">Accepted</p>
                <div className="text-sm text-gray-300">
                  <p className="mb-1">Input: nums=[1,2,3,1]</p>
                  <p>Your Output: true</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}