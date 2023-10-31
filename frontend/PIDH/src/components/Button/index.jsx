const Button = ({ text, onClick, type="button"}) => { 
    return(
        <button type={type} onClick={onClick} className="bg-principal text-white font-medium px-5 py-2.5 rounded-lg text-center">{text}</button>
    )
}
export default Button;