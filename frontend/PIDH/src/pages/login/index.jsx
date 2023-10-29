import { useState } from "react"; 
import Input from '../../components/Input'
import Button from '../../components/Button'

const Login = () => { 
  const [email, setEmail] = useState(""); 
  const [senha, setSenha] = useState("");
  const [error, setError] = useState(""); 

  const submitLogin = async() => {
    if (senha.length < 6 ){
      setError("Verifique suas informações novamente"); 
      return; 
    }
  }
  return(
    <section className="text-red">
     <h1>Iniciar sessão</h1>
     <div>
      <h5 htmlFor="text">Email</h5>
      <Input type="email" value={email} onChange={(e) => {setEmail(e.target.value), setError("")}} placeholder="Digite seu e-mail" required ></Input>
      { /*eventos quando escreve, não esquecer*/}
      <h5 htmlFor="text">Senha</h5>
      <Input type="password" value={senha} onChange={(e) => {setSenha(e.target.value), setError("")}} placeholder="Digite sua senha" required ></Input>
      <label htmlFor="text">{error}</label>
      <Button text="Entrar"></Button>
      <p>Ainda não tem conta <a href="">Registre-se</a></p>
     </div>
    </section>
  )
}


export default Login;