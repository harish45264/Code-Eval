import Header from "./Header";
export default function Homepage() {
  return (
    <div className="min-h-screen bg-white text-gray-900">
      <Header />
      <main className="flex flex-col md:flex-row items-start justify-between px-10 py-20 gap-10">
        {/* Left-aligned welcome section */}
        <section className="md:w-1/2">
          <h1 className="text-5xl font-extrabold mb-4">CodeEval</h1>
          <p className="text-lg text-gray-600 mb-6 max-w-md">
            Welcome to the{" "}
            <span className="font-bold text-black">best coding platform</span> to
            prepare for your next interview.
          </p>
          <div className="flex space-x-4">
            <button className="px-6 py-2 border-2 border-green-500 text-green-500 rounded-full hover:bg-green-500 hover:text-white transition">
              Code Eval Premium
            </button>
          </div>
        </section>
      </main>
    </div>
  );
}