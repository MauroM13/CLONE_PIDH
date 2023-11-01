import logo from '../../../assets/logo.png';
import{ Link } from 'react-router-dom';

function Logo() {
  return (
    <Link to="/" className="flex items-center gap-1">
      <img src={logo} alt="Logo" className="w-12 h-12"/>
      <span className="text-green-400 text-xl"> Five Hotels</span>
    </Link>
  )
}

export default Logo;