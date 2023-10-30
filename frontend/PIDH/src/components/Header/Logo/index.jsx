import logo from '../../../assets/logo.png';

function Logo() {
  return (
    <div className="flex items-center py-2">
      <img src={logo} alt="Logo" className="w-12 h-12"/>
      <span className="text-violet-500"> Five Hotels</span>
    </div>
  )
}

export default Logo;