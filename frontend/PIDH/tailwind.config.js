/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        'principal': "#16a34a"
      },
      fontFamily:{
        'Noto': ['Noto Sans', 'sans'],
    },
    },
  },
  plugins: [],
}
