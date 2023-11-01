import { useEffect, useState } from "react"

function Cards() {
const [cards, setCards] = useState([])
  useEffect( () => {
    const cards = async () => {
      const data = await fetch("../../public/fakeApi/cards.json")
      const {result} = await data.json();
      setCards(result)
    }
    cards()
  }, [])

  return (
    <div>
      <h2>Recomendações</h2>
      <div className="flex w-full gap-4 flex-wrap">
    {
      cards.map( ({img, category, title, location, description}, index) => {
        return (
          <div className="flex justify-center items-center" key={index}>
            <img className="w-56 h-56" src={img} alt={title} />
            <div className="flex flex-col h-full justify-center">
              <h3>{title}</h3>
              <p className="text-sm truncate w-80">{description}</p>
              <span>{location}</span>
              <span>{category}</span>
            </div>          
          </div>
        )
      })
    }
      </div>
    </div>
  )
}

export default Cards;