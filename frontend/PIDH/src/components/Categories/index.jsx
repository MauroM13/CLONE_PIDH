import { useEffect, useState } from "react"

function Categories() {
const [categories, setCategories] = useState([])
  useEffect( () => {
    const categories = async () => {
      const data = await fetch("../../public/fakeApi/categories.json")
      const {categories} = await data.json();
      setCategories(categories)
    }
    categories()
  }, [])

  return (
    <div>
      <h2>Busque por categorias</h2>
      <div className="flex justify-center w-full gap-10">
    {
      categories.map( ({id, description, image, qualification}) => {
        return (
          <div key={id}>
            <img className="w-56 h-56" src={image} alt={description} />
            <div>
              <h3>{description}</h3>
              <p className="text-sm">{qualification}</p>
            </div>          
          </div>
        )
      })
    }
      </div>
    </div>
  )
}

export default Categories