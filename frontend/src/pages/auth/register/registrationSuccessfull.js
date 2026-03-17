import React from 'react';
import { Link } from 'react-router-dom';
import Logo from '../../../components/utils/Logo';

const RegistrationSuccessfull = () => {
    return (
        <div className='container'>
            <div className="auth-form">
                <Logo />
                <h3 style={{ textAlign: 'center' }}>🎉 Registration Successful!</h3><br />
                <div className='msg' style={{ textAlign: 'center', fontWeight: 600 }}>
                    Your account has been verified and is ready to use.
                </div>
                <br />
                <div className='input-box'>
                    <Link to='/auth/login'>
                        <input
                            type='button'
                            value='Go to Login'
                            className='button button-fill'
                            style={{ cursor: 'pointer' }}
                        />
                    </Link>
                </div>
            </div>
        </div>
    );
};

export default RegistrationSuccessfull;
