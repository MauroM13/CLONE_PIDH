import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav className="flex gap-6">
      <Link className="text-green-400 border-green-400 border px-4 rounded-md py-1" to="/login">Login</Link>
      <Link className="bg-green-400 px-4 rounded-md text-white py-1" to="/register">Cadastre-se</Link>
    </nav>
  );
}

export default Navbar;
