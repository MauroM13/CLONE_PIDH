import Footer from "./components/Footer";
import RoutesApp from "./routes";

function App() {

  return (
    <main className="overflow-x-hidden min-h-screen flex flex-col justify-between bg-gray-50 dark:bg-zinc-800 dark:text-zinc-50">
      <RoutesApp />
      <Footer />
    </main>
  )
}

export default App

