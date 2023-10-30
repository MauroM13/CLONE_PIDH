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

    const res = await Login(email, senha); 
    if(res) { 
      setError(res); 
    } else { 
      NavigationPreloadManager("/"); 
    }
  }
  return(
    <section className="text-blue">
     <h1>Iniciar sessão</h1>
     <div>
      <label htmlFor="email">Email</label>
      <Input type="email" id="email" value={email} onChange={(e) => {setEmail(e.target.value), setError("")}} placeholder="Digite seu e-mail" required></Input>

      <label htmlFor="senha">Senha</label>
      <Input type="password" id="senha" value={senha} onChange={(e) => {setSenha(e.target.value), setError("")}} placeholder="Digite sua senha" required ></Input>
      <p>{error}</p>
      <Button text="Entrar" onClick={submitLogin}></Button>
      <p>Ainda não tem conta <a href="">Registre-se</a></p>
     </div>
    </section>
  )
}


export default Login;