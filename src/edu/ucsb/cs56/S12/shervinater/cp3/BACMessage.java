package edu.ucsb.cs56.S12.shervinater.cp3;

/** Message for BAC Gui
 @author Shervin Shaikh and Ramon Rovirosa
 @version 05/30/2012 for choice points
*/

public final class BACMessage{

    /**
       Constructor 
    */
    private BACMessage(){}

    /** 
	Return a string containing information about a users blood alcohol level.
	@param BAC is the blood alcohol level
	@return message is a string representing information about the blood alcohol level.
    */
    public static String GuiMessage(double BAC){
	String message = "Blood Alcohol Content is: " + String.format("%1$.3f", BAC) + "\n\n";
	String aboveLegalLimit = "You're above the legal limit of .08! Do not drive!!\n";
        
        if(BAC == 0) message += "You're sober!! :)\n\n";
        else if(BAC > 0 && BAC <.04)
            message +="Symptoms/Impairment: No loss of coordination, slight euphoria and loss of shyness.Depressant effects are not apparent.\n\n";
        else if(BAC >= .04 && BAC <.07)
            message += "Symptoms/Impairment: Feeling of well-being, relaxation, lower inhibitions, sensation of warmth. Euphoria. Some minor impairment of reasoning and memory, lowering of caution.\n\n";
        else if(BAC >= .07 && BAC < .08)
            message += "Symptoms/Impairment: Slight impairment of balance, speech, vision, reaction time, and hearing. Euphoria. Judgment and self- control are reduced, and caution, reason and memory are impaired.\n\n";
	else if(BAC >= .08 && BAC < .10)
	    message += aboveLegalLimit + "Symptoms/Impairment: Slight impairment of balance, speech, vision, reaction time, and hearing. Euphoria. Judgment and self- control are reduced, and caution, reason and memory are impaired.\n\n";
        else if(BAC >= .10 && BAC < .125)
            message +=  aboveLegalLimit +"Symptoms/Impairment: Significant impairment of motor coordination and loss of good judgment. Speech may be slurred; balance, vision, reaction time and hearing will be impaired. Euphoria. It is illegal to operate a motor vehicle at this level of intoxication. \n\n";
        else if(BAC >= .13 && BAC < .16)
            message +=  aboveLegalLimit + "Symptoms/Impairment: Gross motor impairment and lack of physical control. Blurred vision and major loss of balance. Euphoria is reduced and dysphoria is beginning to appear.\n\n";
        else if(BAC >= .16 && BAC < .25)
            message += aboveLegalLimit + "Symptoms/Impairment: Dysphoria (anxiety, restlessness) predominates, nausea may appear. The drinker has the appearance of a \"sloppy drunk.\"\n\n";
        else if(BAC >= .25 && BAC < .3)
            message += aboveLegalLimit + "Symptoms/Impairment: Individual may need assistance in walking; total mental confusion. Dysphoria with nausea and some vomiting.\n\n";
        else if(BAC >= .3 && BAC < .4)
            message +=  aboveLegalLimit + "Symptoms/Impairment: Loss of consciousness.\n\n";
        else
            message +=  aboveLegalLimit + "Symptoms/Impairment: Not Recommended!  Onset of coma, possible death due to respiratory arrest.\n\n";
	
	return message;
    }
}