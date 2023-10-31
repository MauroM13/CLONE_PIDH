const Input = ({ type, id , value, onChange, placeholder }) => { 
    return(
        <input className="bg-gray-50 border border-gray-300 text-sm font-medium text-gray-900 p-2" type={type} id={id} value={value} onChange={onChange} placeholder={placeholder}/>
    )
}

export default Input; 