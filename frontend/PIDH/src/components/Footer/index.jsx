import { BsInstagram, BsFacebook, BsLinkedin, BsTwitter } from "react-icons/bs";

function Footer() {
  return (
    <footer className="w-screen h-14 flex justify-around bg-principal items-center">
      <p className="text-center text-gray-200">
        &copy; 2021 Five Hotels. All rights reserved.
      </p>
      <div className="flex gap-8 text-gray-200">
        <a
          href="https://www.instagram.com/"
          target="_blank"
          rel="noreferrer"
          className="hover:text-accent-focus"
        >
          <BsInstagram size={25} />
        </a>
        <a
          href="https://www.facebook.com/"
          target="_blank"
          rel="noreferrer"
          className="hover:text-accent-focus"
        >
          <BsFacebook size={25} />
        </a>
        <a
          href="https://www.linkedin.com/"
          target="_blank"
          rel="noreferrer"
          className="hover:text-accent-focus"
        >
          <BsLinkedin size={25} />
        </a>
        <a
          href="https://www.twitter.com/"
          target="_blank"
          rel="noreferrer"
          className="hover:text-accent-focus"
        >
          <BsTwitter size={25} />
        </a>
      </div>
    </footer>
  );
}

export default Footer;
