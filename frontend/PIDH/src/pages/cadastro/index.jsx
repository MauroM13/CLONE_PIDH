import { useState } from "react"; 
import Input from '../../components/Input'
import Button from '../../components/Button'


const Cadastro = () => { 
    const [nome, setNome] = useState("");
    const [sobrenome, setSobrenome] = useState(""); 
    const [email, setEmail] = useState(""); 
    const [senha, setSenha] = useState("");
   return(
      <section>
       <h1>Criar sua conta</h1>
       <label htmlFor="text">Nome</label>
       <Input type="text"  value={nome} onChange={(e) => {setNome(e.target.value), setError("")}} placeholder="Digite seu nome" required ></Input>
       <label htmlFor="text">Sobrenome</label>
       <Input type="text"  value={sobrenome} onChange={(e) => {setSobrenome(e.target.value), setError("")}} placeholder="Digite seu sobrenome" required ></Input>
       <label htmlFor="text">E-mail</label>
       <Input type="text"  value={email} onChange={(e) => {setEmail(e.target.value), setError("")}} placeholder="Digite seu e-mail" required ></Input>
       { /*talvez criar um estado para repetir senha, somente dele*/}
       <label htmlFor="text">Repita seu E-mail</label>
       <Input type="email"  value={email} onChange={(e) => {setEmail(e.target.value), setError("")}} placeholder="Repita seu e-mail" required ></Input>
       <label htmlFor="text">Senha</label>
       <Input type="password"  value={senha} onChange={(e) => {setSenha(e.target.value), setError("")}} placeholder="Digite sua senha" required ></Input>
       <Button text="Registre-se"></Button>
       <p>Já tem conta? <a href="">Faça Login</a></p>
      </section>
   )
}

export default Cadastro; 