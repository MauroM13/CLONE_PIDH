import { useState } from "react"; 
import Input from '../../components/Input'
import Button from '../../components/Button'


const Cadastro = () => { 
    const [nome, setNome] = useState("");
    const [sobrenome, setSobrenome] = useState(""); 
    const [email, setEmail] = useState(""); 
    const [repeatemail, setRepeatEmail] = useState(""); 
    const [senha, setSenha] = useState("");
   return(
      <section>
       <h1>Criar sua conta</h1>
       <label htmlFor="nome">Nome</label>
       <Input type="text" id="nome" value={nome} onChange={(e) => {setNome(e.target.value), setError("")}} placeholder="Digite seu nome" required ></Input>
       <label htmlFor="sobrenome">Sobrenome</label>
       <Input type="text"  id="sobrenome"  value={sobrenome} onChange={(e) => {setSobrenome(e.target.value), setError("")}} placeholder="Digite seu sobrenome" required ></Input>
       <label htmlFor="email">E-mail</label>
       <Input type="email" id="email"  value={email} onChange={(e) => {setEmail(e.target.value), setError("")}} placeholder="Digite seu e-mail" required ></Input>
       { /*talvez criar um estado para repetir senha, somente dele*/}
       <label htmlFor="repeatemail">Repita seu E-mail</label>
       <Input type="email" id="repeatemail" value={repeatemail} onChange={(e) => {setRepeatEmail(e.target.value), setError("")}} placeholder="Repita seu e-mail" required ></Input>
       <label htmlFor="senha">Senha</label>
       <Input type="password" id="senha" value={senha} onChange={(e) => {setSenha(e.target.value), setError("")}} placeholder="Digite sua senha" required ></Input>
       <Button text="Registre-se"></Button>
       <p>Já tem conta? <a href="">Faça Login</a></p>
      </section>
   )
}

export default Cadastro; 