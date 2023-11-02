import { useState } from "react"; 
import Input from '../../components/Input'
import Button from '../../components/Button'
import{ Link } from 'react-router-dom';

const Cadastro = () => { 
    const [nome, setNome] = useState("");
    const [sobrenome, setSobrenome] = useState(""); 
    const [email, setEmail] = useState(""); 
    const [repeatemail, setRepeatEmail] = useState(""); 
    const [senha, setSenha] = useState("");
    const [error, setError] = useState("");


    const submitCadastro = async() => {
      const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
  
      if ( nome.length < 3 || sobrenome.length < 4 || !emailRegex.test(email) 
      || !emailRegex.test(repeatemail) || !email.match(repeatemail) || senha.length < 7 ){
        setError("Verifique suas informações novamente"); 
        return; 
      }
    }

   return(
      <section className="w-screen min-h-screen flex flex-col items-center 
      justify-center px-6 py-8 text-start font-Noto md:w-full md:py-4 lg:mt-4 ">
       <h1 className="text-xl font-semibold leading-tight tracking-tight text-gray-900 md:text-2xl">Criar sua conta</h1>
       <form className="w-full flex flex-col p-6 space-y-4 md:mt-0 md:space-y-2 md:w-auto">
         <div className="flex flex-col gap-2 md:flex-row md:items-center md:justify-evenly lg:w-100 lg:h-30 md:gap-2">
         <label htmlFor="nome">Nome</label>
        <Input type="text" id="nome" value={nome} onChange={(e) => {setNome(e.target.value), setError("")}} placeholder="Mariana" required ></Input>
        <label htmlFor="sobrenome">Sobrenome</label>
       <Input type="text"  id="sobrenome"  value={sobrenome} onChange={(e) => {setSobrenome(e.target.value), setError ("")}} placeholder="Silva" required ></Input>
         </div>
       
       <label htmlFor="email">E-mail</label>
       <Input type="email" id="email"  value={email} onChange={(e) => {setEmail(e.target.value), setError("")}} placeholder="nome@gmail.com" required ></Input>

       <label htmlFor="repeatemail">Repita seu e-mail</label>
       <Input type="email" id="repeatemail" value={repeatemail} onChange={(e) => {setRepeatEmail(e.target.value), setError("")}} placeholder="nome@gmail.com" required ></Input>
       <label htmlFor="senha">Senha</label>
       <Input type="password" id="senha" value={senha} onChange={(e) => {setSenha(e.target.value), setError("")}} placeholder="••••••••" required ></Input>
       <p>{error}</p>
       <Button text="Registre-se" onClick={submitCadastro}></Button>
       <p className="text-sm font-light text-gray-600 text-center">Já tem conta? <Link to="/login" className="font-medium text-principal hover:underline">Faça login</Link></p>
       </form>
      </section>
   )
}

export default Cadastro; 