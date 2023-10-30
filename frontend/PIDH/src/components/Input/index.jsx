const Input = ({ type, id , value, onChange, placeholder }) => { 
    return(
        <input type={type} id={id} value={value} onChange={onChange} placeholder={placeholder}/>
    )
}

export default Input; 