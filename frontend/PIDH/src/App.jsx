import { useState } from 'react'
import './App.css'
import Login from './pages/login'
import Cadastro from './pages/cadastro'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Login></Login>
    </>
  )
}

export default App
