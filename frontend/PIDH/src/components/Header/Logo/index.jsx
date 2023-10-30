import logo from '../../../assets/logo.png';

function Logo() {
  return (
    <div>
      <img src={logo} alt="Logo" />
      <span className="text-violet-500"> Five Hotels</span>
    </div>
  )
}

export default Logo;