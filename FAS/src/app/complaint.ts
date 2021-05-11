export class Complaint {

    constructor(
        public complaint_id: number,
        public complaint_type: string,
        public complaint_text: string,
        public complaint_status: string,
        public farmer_id: number,
    ) { }
}
