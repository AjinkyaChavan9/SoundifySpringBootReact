import { useState } from 'react';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import { useNavigate } from 'react-router-dom';
export const SignUp = () => {
  
  const[credentials, setCredentials] = useState({
                firstName: "",lastName: "", email:"", mobile:"", password:"", confirmPassword: ''});
    const[message, setMessage] = useState("");

    
    var navigate = useNavigate();

    var OnTextChange = (args)=>{
        var copyOfCredentials = {...credentials}
        copyOfCredentials[args.target.name] = args.target.value;
        setCredentials(copyOfCredentials);

    }

    var ShowMessage = (message) =>{
      setMessage(message);
      setTimeout(()=>{setMessage("")}, 3000)

  }
    var signUpDB = () =>{

      if (credentials.password !== credentials.confirmPassword) {
        ShowMessage('Passwords do not match');
        return;
      }
      var helper = new XMLHttpRequest();
        helper.onreadystatechange = () => {
            if (helper.readyState == 4 && helper.status == 200) {
                debugger;
                var result = JSON.parse(helper.responseText);
                if ( result.status == 'success' && result.data.affectedRows > 0) {
                    ShowMessage("Login successfully");
                    console.log("success");
                    setTimeout(()=>{navigate('/login')}, 3000)
                    
                }
                else{
                  ShowMessage("Error, Register Again!! ")
                }

            }
        }
       console.log(credentials)
        helper.open("POST", "http://127.0.0.1:9898/user/register");
        helper.setRequestHeader("content-type", "application/json")
        helper.send(JSON.stringify(credentials));

    }


  return <div className="container">
    <form className="">
      <div className="form-group ">
      {/* <h1></h1> */}
      </div>

      <div className="row">
                    <div className="input-field col s6">
                        <input id="firstName" name="firstName" type="text" className="validate"
                        value={credentials.firstName}
                        onChange={OnTextChange} />
                        <label htmlFor="firstName">First Name</label>
                    </div>
                    <div className="input-field col s6">
                        <input id="lastName" name="lastName" type="text" className="validate"
                        value={credentials.lastName}
                        onChange={OnTextChange} />
                        <label for="lastName">Last Name</label>
                    </div>
                    
          </div>

          
          <div className="row">
                    <div className="input-field col s6">
                        <input id="email" name="email" type="email" className="validate"
                        value={credentials.email}
                        onChange={OnTextChange} />
                        <label htmlFor="email">Email</label>
                    </div>
                    <div className="input-field col s6">
                        <input id="mobile" name="mobile" type="number" className="validate"
                        value={credentials.mobile}
                        onChange={OnTextChange} />
                        <label for="mobile">Mobile</label>
                    </div>
                    
          </div>
          <div>
          <div className="row">
                        <div className="input-field col s6">
                            <input id="password" name="password" type="password" className="validate" 
                            value={credentials.password}
                            onChange={OnTextChange}/>
                            <label htmlFor="password">Password</label>
                        </div>
                        <div className="row">
                        <div className="input-field col s6">
                            <input id="confirmPassword" name="confirmPassword" type="password" class="validate" 
                            value={credentials.confirmPassword}
                            onChange={OnTextChange}/>
                            <label htmlFor="password">Confirm Password</label>
                        </div>
                    </div>
           </div>

          </div>
        <div className="text-center">
        <button type="button" className="btn btn-primary" onClick={signUpDB}>Register</button>
        
        </div>
        {message && ( <div className="card-panel teal lighten-2">{message}</div> )}
        
    </form>
  </div>
}
