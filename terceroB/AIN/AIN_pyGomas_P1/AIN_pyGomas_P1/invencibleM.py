import json
from loguru import logger
from spade.behaviour import OneShotBehaviour
from spade.template import Template
from spade.message import Message
from pygomas.agents.bditroop import BDITroop
from pygomas.agents.bdimedic import BDIMedic
from pygomas.ontology import Belief
from agentspeak import Actions
from agentspeak import grounded
from agentspeak.stdlib import actions as asp_action


from pygomas.agents.agent import LONG_RECEIVE_WAIT

class BDIMInvencible(BDIMedic):

     def add_custom_actions(self, actions):
        super().add_custom_actions(actions)
        
        @actions.add(".superhealth", 0)      
        def _superhealth(agent, term, intention):
            self.health=200
            self.bdi.set_belief(Belief.HEALTH, self.health) 
            yield

      
#        super().__init__(actions=example_agent_actions, *args, **kwargs)
