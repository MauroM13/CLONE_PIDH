import { useState } from "react"; 
import Input from '../../components/Input'
import Button from '../../components/Button'

const Login = () => { 
  const [email, setEmail] = useState(""); 
  const [senha, setSenha] = useState("");
  const [error, setError] = useState(""); 

  const submitLogin = async() => {
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

    if ( !emailRegex.test(email) || senha.length < 7 ){
      setError("Verifique suas informações novamente"); 
      return; 
    }
  }
  return(
    <section className="w-screen h-full flex flex-col items-center justify-center px-6 py-8 text-start md:w-full md:py-4 lg:mt-4">
     <h1 className="text-4x1 font-bold">Iniciar sessão</h1>
     <form className=" flex flex-col p-6 space-y-4  md:mt-0 md:space-y-2">
      <label htmlFor="email">E-mail</label>
      <Input type="email" id="email" value={email} onChange={(e) => {setEmail(e.target.value), setError("")}} placeholder="nome@gmail.com" required></Input>
        
      <label htmlFor="senha">Senha</label>
      <Input type="password" id="senha" value={senha} onChange={(e) => {setSenha(e.target.value), setError("")}} placeholder="••••••••" required ></Input>
      <p>{error}</p>
      <Button text="Entrar" onClick={submitLogin} ></Button>
      <p className="text-sm font-light text-gray-600">Ainda não tem conta <a href="" className="font-medium text-principal hover:underline">Registre-se</a></p>
     </form>
    </section>
  )
}


export default Login;