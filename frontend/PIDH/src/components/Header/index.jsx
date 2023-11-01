import Logo from "./Logo"
import Navbar from "./Navbar/index"

function Header() {
  return (
    <header className="w-screen h-20 flex items-center justify-between px-8 shadow-md bg-white dark:bg-zinc-900">
      <Logo />
      <Navbar />
    </header>
  )
}

export default Header
